package com.iu.s1.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	// list
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void list() throws Exception{
		System.out.println("list 들어옴");
	}
}
