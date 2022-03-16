package com.iu.s1.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class TestInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		System.out.println("Controller 진입 전 실행");
		
		// return이 ture면 Contorller로 계속 진행
		// false면 Controller 진행 X
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		System.out.println("Controller에서 Dispathcer Servlet으로 가기전 실행");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		System.out.println("View(jsp) 랜더링 후 (HTML 변환 후) 실행");
	}
	
	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("비동기 요청시 postHandle과 aftercompletion을 수행하지 않고 이 메서드를 실행");
		
		super.afterConcurrentHandlingStarted(request, response, handler);
	}
}
