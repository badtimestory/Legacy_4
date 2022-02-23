package com.iu.s1.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.bankbook.BankBookDTO;

@Controller
@RequestMapping("notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	// update
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(NoticeDTO noticeDTO, Model model) throws Exception {
		
		noticeDTO = noticeService.detail(noticeDTO);
		model.addAttribute("dto", noticeDTO);
		
		System.out.println(noticeDTO.getNum());
		System.out.println(noticeDTO.getTitle());
		System.out.println(noticeDTO.getContents());
		System.out.println(noticeDTO.getWriter());
		System.out.println(noticeDTO.getRegDate());
		System.out.println(noticeDTO.getHit());
	
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(NoticeDTO noticeDTO) throws Exception {
		
		int result = noticeService.update(noticeDTO);
		
		return "redirect:./list";
		
	}
	
	// delete
	@RequestMapping(value = "delete")
	public String delete(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.delete(noticeDTO);
		
		return "redirect:./list";
	}
	
	// list
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mv) throws Exception {
		List<NoticeDTO> ar = noticeService.list();
		mv.addObject("list", ar);
		mv.setViewName("notice/list");
		
		return mv;
	}
		
	// detail
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void detail(NoticeDTO noticeDTO, Model model) throws Exception {
		noticeDTO = noticeService.detail(noticeDTO);
		model.addAttribute("dto", noticeDTO);
	}
	
	// add form 이동
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() throws Exception {
		
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.add(noticeDTO);
		
		return "redirect:./list";
	}
}
