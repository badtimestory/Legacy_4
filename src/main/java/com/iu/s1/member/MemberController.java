package com.iu.s1.member;

import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	// insert
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(MemberDTO memberDTO, MultipartFile photo) throws Exception{
		System.out.println(photo.getOriginalFilename());
		System.out.println(photo.getSize());//byte
	
		int result = memberService.join(memberDTO, photo);
		
		return "redirect:../";
	}
	
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public void join() throws Exception {
		
	}
	
	@RequestMapping(value = "joinCheck", method = RequestMethod.GET)
	public void joinCheck() throws Exception {
		
	}
	
	// login
	@RequestMapping(value = "login", method = RequestMethod.POST)
	// parameter는 전부 String type 
	public String login(HttpSession session, MemberDTO memberDTO, String remember, Model model, HttpServletResponse response) throws Exception {		
		// 서버에서 쿠키 생성
		if(remember != null && remember.equals("1")) {	// check하면 1 아니면 null
			// cookie 생성, id를 저장
			Cookie cookie = new Cookie("remember", memberDTO.getId());
//			cookie.setPath("/");
			// 유효시간을 영구적으로 설정
			cookie.setMaxAge(-1);
			
			// 응답으로 보냄(쿠키를 추가함)
			response.addCookie(cookie);
			
		} else {
			Cookie cookie = new Cookie("remember", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
		memberDTO = memberService.login(memberDTO);
		
//		String path = "redirect:./login";
//		
//		// 로그인이 성공했을 때
//		if(memberDTO != null) {
//			session.setAttribute("member", memberDTO);
//			path = "redirect:../";
//		}
		
		String message = "Login Fail";
		String p = "./login";
		
		if(memberDTO != null) {
			session.setAttribute("member", memberDTO);
			message = "Login Success";
			p = "../";
		}
		
		model.addAttribute("message", message);
		model.addAttribute("path", p);
		String path = "common/result";
		return path;
		
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void login(Model model, @CookieValue(value = "remember", defaultValue = "") String rememberId) throws Exception {
//		model.addAttribute("rememberId", rememberId);
	}
	
	// logout
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		
		return "redirect:../";
	}
	
	// mypage
	@RequestMapping(value = "mypage", method = RequestMethod.GET)
		public void mypage(Model model, MemberDTO memberDTO, HttpSession session) throws Exception {
			memberDTO = (MemberDTO)session.getAttribute("member");
			memberDTO = memberService.mypage(memberDTO);
			model.addAttribute("dto", memberDTO);
		}
	
//	public ModelAndView mypage(HttpSession session) throws Exception {
//		ModelAndView mv = new ModelAndView();
//		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
//		memberDTO = memberService.mypage(memberDTO);
		// jsp의 경로명
//		mv.setViewName("member/mypage");
//		mv.addObject("dto", memberDTO);
//		return mv;
//	}
	
	
}
