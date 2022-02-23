package com.iu.s1.member;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyjuintTest;

public class MemberDAOTest extends MyjuintTest{

	@Autowired
	private MemberDAO memberDAO;
	
	// @Test
	public void joinTest() throws Exception {
		MemberDTO memberDTO = new MemberDTO();	// 더미데이터
		memberDTO.setId("testid2");
		memberDTO.setPw("testpw2");
		memberDTO.setName("testName2");
		memberDTO.setPhone("010-1111-2222");
		memberDTO.setEmail("test2@gmail.com");
		
		int result = memberDAO.join(memberDTO);
	
		assertEquals(1, result);
	}
	
	@Test
	public void loginTest() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("ID1");
		memberDTO.setPw("PW1");
		// 조회 결과물을 memberDTO로 보냄
		memberDTO = memberDAO.login(memberDTO);
		
		assertNotNull(memberDTO);

	}
	
	@Test
	public void mypageTest() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("ID1");
		memberDTO = memberDAO.mypage(memberDTO);
		
		assertNotNull(memberDTO);
	}
}
