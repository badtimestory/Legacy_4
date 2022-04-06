package com.iu.s1.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	@Autowired
	private ServletContext servletContext;
	
	public boolean remove(String path, String fileName) throws Exception {
		// 파일을 HDD에서 삭제
		// 저장된 폴더명, 저장된 파일명 2가지가 필요
		path = servletContext.getRealPath(path);
		
		File file = new File(path, fileName);
		
		return file.delete();
		
	}
	
	public String save(MultipartFile multipartFile, String path) throws Exception {
		// 파일저장은 tomcat이 아니라 OS에서 저장
		// 1. 저장 위치 path : /resources/upload/member
		String realPath = servletContext.getRealPath(path);
		System.out.println(realPath);
		
		// 파일객체에다가 폴더정보를 담음
		File file = new File(realPath);
//		System.out.println("file2.exists : " + file2.exists());
//		System.out.println("file2.isDirectory : " + file2.isDirectory());
		
		// 폴더가 없을 때
		if(!file.exists()) {
//			file2.mkdir();	// 중간에 폴더가 없으면 에러
			file.mkdirs();	// 중간 폴더가 없으면 중간 폴더도 생성
		}
		
		// 1. 시간을 이용하는 방법
		// Calendar는 추상클래스라 직접 객체 생성 불가능
		Calendar ca = Calendar.getInstance();
		long l = ca.getTimeInMillis();	// 현재 시간을 밀리세컨즈로 변환
		System.out.println("Time : " + l);
		String oriName = multipartFile.getOriginalFilename();	// *.jpg
		
		String fileName = l + "_" + oriName;
		System.out.println("Filename : " + fileName);
		
		// 2. UUID 사용
		fileName = UUID.randomUUID().toString();
		fileName = fileName + "_" + oriName;
		System.out.println("UUID : " + fileName);
		
		// file HDD에 저장
		// 1. MultipartFile 클래스의 transferTo 메서드 사용
//		file = new File(realPath, fileName);	// realPath 폴더에 fileName 이름으로 저장
//		file = new File(file, fileName);
//		multipartFile.transferTo(file);
		
		// 2. FileCopyUtils
		file = new File(file, fileName);
		FileCopyUtils.copy(multipartFile.getBytes(), file);

		
		return fileName;
	}

}
