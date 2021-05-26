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
  )   {System.out.println("head = " + head); //JSP�� name�� ���� head��� ������ ��ġ!
	   System.out.println("title = " + title);//JSP�� name�� ���� title��� ������ ��ġ!
	   System.out.println("body = " + body);//JSP��  name�� ���� body��� ������ ��ġ!

		return "redirect:write_result";   } // return "redirect: ��ġ�ϴ� url "
	
@GetMapping("write_result")
	public String result () {
		return "board/content";  //return �� view�� ��ġ�ϴ� ���ϸ��� ������
	}
}
	
			
