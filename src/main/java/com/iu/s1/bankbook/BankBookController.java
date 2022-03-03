package com.iu.s1.bankbook;

import java.util.List;

import javax.swing.text.View;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.util.Pager;

@Controller
@RequestMapping("bankbook/*")
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;
	
	// update
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(BankBookDTO bankBookDTO, Model model) throws Exception {
		
		System.out.println(bankBookDTO.getBookNumber());
		
		bankBookDTO = bankBookService.detail(bankBookDTO);
		// key는 개발자가 임의로 설정
		model.addAttribute("dto", bankBookDTO);
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(BankBookDTO bankBookDTO) throws Exception {
		int result = bankBookService.update(bankBookDTO);
		return "redirect:./list";
	}
	
	//delete
	@RequestMapping(value = "delete")
	public String delete(BankBookDTO bankBookDTO, Model model) throws Exception {
		int result = bankBookService.delete(bankBookDTO);
		
		String view = "common/result";
		
		// 삭제 성공했을 때
		if(result == 1) {
			view = "redirect:./list";
		
		// 삭제 실패했을 때
		} else {
			model.addAttribute("message", "없는 번호입니다.");
			model.addAttribute("path", "./list");
		}
		
		return view;
	}
	
	// list
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mv, Pager pager) throws Exception {
		// ModelAndView
		// 매개변수 선언 or 메서드내에 객체 생성
		// ModelAndView mv = new ModelAndView();
		List<BankBookDTO> ar = bankBookService.list(pager);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("bankbook/list");
		
		return mv;
	}
	
	// detail
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(BankBookDTO bankBookDTO, Model model) throws Exception {
		bankBookDTO = bankBookService.detail(bankBookDTO);
		
		String view = "common/result";
		
		// 조회가 성공하면 출력
		if(bankBookDTO != null) {
			view = "bankbook/detail";
			model.addAttribute("dto", bankBookDTO);
			
		// 조회가 실패하면 alert으로 없는 번호입니다. --> 다시 list로 이동
		// /common/result.jsp 활용
		} else {
			model.addAttribute("message", "없는 번호입니다.");
			model.addAttribute("path", "./list");
		}
		
		return view;
		
	}
	
	// Insert form 이동
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() throws Exception {
		
	}
	
	// DB에 Insert
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(BankBookDTO bankBookDTO) throws Exception {
		int result = bankBookService.add(bankBookDTO);
		
		return "redirect:./list";
	}
	
}
