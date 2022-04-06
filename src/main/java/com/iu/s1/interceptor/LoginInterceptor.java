package com.iu.s1.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.s1.member.MemberDTO;

// 로그인이 되어있는지 판별하는 클래스
// @Component
public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("Login Interceptor");
		
		// 내장객체는 다른 영역의 내장 객체를 불러 올 수 있음 (좁은 영역->큰 영역)
		// page -> request -> sesstion -> application(ServletContext)
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		
		boolean check = true;
		
		// 로그인 검사
		if(memberDTO == null) {
			check = false;
//			// 1. foward 형식 - servlet 문법 사용
			// views/common/result에 ${message}, ${path}
//			request.setAttribute("message", "로그인이 필요합니다.");
//			request.setAttribute("path", "../member/login");
//			RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/common/result.jsp");
//			view.forward(request, response);
			
			// 2. redirect
			response.sendRedirect("../member/login");
		}
		
		return check;
	}

}
