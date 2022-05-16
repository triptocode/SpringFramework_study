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
	public String threefruit1() {
		
		return "fruit";
	}
	
	@PostMapping("/fruit2")
	public String threefruit2(
		// request get parametor로 못받는다
		// 그래서 jsp, servlet에서는 request get parametor values로
   
			
  //@RequestParam String[] fruit) {
  @RequestParam List <String> fruit) {   //jsp�뿉 input name ="fruit"瑜� 蹂��닔濡� �궗�슜�븳�떎 
  // fruit는 form의 name 값 	
		for(String f: fruit) {
			System.out.println("f="+f);
		}
		return "redirect:fruit1";
		                                                                           
	}
	

}
