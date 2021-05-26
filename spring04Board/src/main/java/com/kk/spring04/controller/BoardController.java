package com.kk.spring04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board")
public class BoardController {
	
@GetMapping("/write1")
	public String writePage() {
		return "board/write";	}
@PostMapping("/write2")
	public String writeSave
  ( @RequestParam(required=false, defaultValue="optional") 
	                String head,
	  @RequestParam String title,
	  @RequestParam String body
  )   {System.out.println("head = " + head); //JSP의 name에 적은 head라는 변수명 일치!
	   System.out.println("title = " + title);//JSP의 name에 적은 title라는 변수명 일치!
	   System.out.println("body = " + body);//JSP의  name에 적은 body라는 변수명 일치!

		return "redirect:write_result";   } // return "redirect: 일치하는 url "
	
@GetMapping("write_result")
	public String result () {
		return "board/content";  //return 은 view의 일치하는 파일명을 보여줌
	}
}
	
			
