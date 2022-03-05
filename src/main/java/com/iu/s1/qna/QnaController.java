package com.iu.s1.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	// list
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model) throws Exception {
		
		List<QnaDTO> ar = qnaService.list();
		model.addAttribute("list", ar);
		
		return "qna/list";
	}
	
	// add get
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() throws Exception {
		
	}
	
	// add post
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(QnaDTO qnaDTO) throws Exception {
		int result = qnaService.add(qnaDTO);
		
		return "redirect:./list";
	}
	
	// detail
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void detail(QnaDTO qnaDTO, Model model) throws Exception {
		qnaDTO = qnaService.detail(qnaDTO);
		model.addAttribute("dto", qnaDTO);
		
	}

}
