package com.iu.s1.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
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
	
}
