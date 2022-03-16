package com.iu.s1.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.s1.board.BoardDTO;
import com.iu.s1.member.MemberDTO;

// xml에 객체 생성해서 Annotation 안줘도 됨
// 작성자와 로그인한 사용자의 ID가 같은지 확인하기 위한 인터셉터
public class WriterCheckInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("WriterCheck Interceptor PostHandle");
		
		String method = request.getMethod();
		System.out.println("Method : " + method);
		
		if(method.equals("POST")) {
			return;
		}
		
		// login 정보
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		
		// writer 정보
		Map<String, Object> map = modelAndView.getModel();
		BoardDTO boardDTO = (BoardDTO)map.get("dto");
		
		if(!memberDTO.getId().equals(boardDTO.getWriter())) {
			// Spring 문법
			// 1. forward
			modelAndView.addObject("message", "수정 권한이 없습니다.");
			modelAndView.addObject("path", "./list");
			modelAndView.setViewName("common/result");
			
			// 2. redirect
		}
		
	}
}
