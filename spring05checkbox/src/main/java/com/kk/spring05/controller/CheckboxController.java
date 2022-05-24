package com.kk.spring05.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping ("/checkbox")
public class CheckboxController {
	@GetMapping("/fruit1")
	public String fruitType1() {		
		return "fruit";        }	
	@PostMapping("/fruit2")
	public String fruitType2 ( @RequestParam List <String> nameFruit) 
	{ //public String threefruit2( @Requespublic String[] fruit) {
      //  jsp, servlet에서는 request get parameter values로
      // request get parameter로 못받는다       
      // List 변수 nameFruit 는 jsp의 input name ="nameFruit" 	
		for(String f: nameFruit) {
			System.out.println("f="+f); // Console에 출력하여 확인가능	
		    }
		return "redirect:fruit1"; // redirect: 다시 요청할url 
        // (post의 뷰JSP 따로생성하지 않고 보여줄화면의 기존URL로 재요청)                                                                           
	}	
}
