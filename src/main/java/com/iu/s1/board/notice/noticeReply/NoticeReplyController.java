package com.iu.s1.board.notice.noticeReply;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/noticeReply/**")
public class NoticeReplyController {
	@Autowired
	private NoticeReplyService noticeReplyService;
	
	// @RequestMapping(value = "add", method = RequestMethod.POST)
	@PostMapping("add")
	public String add(NoticeReplyDTO noticeReplyDTO, Model model) throws Exception {
		int result = noticeReplyService.add(noticeReplyDTO);
		System.out.println("add method 실행");
		System.out.println(result);
		model.addAttribute("result", result);
		return "common/ajaxResult";
//		return "redirect:../notice/list";
	}
	
	@GetMapping("list")
	public ModelAndView list(NoticeReplyDTO noticeReplyDTO) throws Exception {
		System.out.println("List Method 실행");
		System.out.println(noticeReplyDTO.getNum());
		List<NoticeReplyDTO> ar = noticeReplyService.list(noticeReplyDTO);
				
		System.out.println(ar);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("noticeReply", ar);
		mv.setViewName("common/noticeReply");
		
		return mv;
	}
	
	@PostMapping("delete")
	public ModelAndView delete(NoticeReplyDTO noticeReplyDTO) throws Exception {
		System.out.println(noticeReplyDTO.getReplyNum());
		int result = noticeReplyService.delete(noticeReplyDTO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/ajaxResult");
		mv.addObject("result", result);
		
		return mv;
	}
	
	@ PostMapping("update")
	public ModelAndView update(NoticeReplyDTO noticeReplyDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println(noticeReplyDTO.getContents());
		System.out.println(noticeReplyDTO.getReplyNum());
		int result = noticeReplyService.update(noticeReplyDTO);
		
		System.out.println(result);
		mv.setViewName("common/ajaxResult");
		mv.addObject("result", result);
		
		return mv;
	}
	
	
}
