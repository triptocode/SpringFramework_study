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
			//@RequestParam String[] fruit) {
			 @RequestParam List <String> fruit) {   //jsp에 input name ="fruit"를 변수로 사용한다 
		for(String f: fruit) {
			System.out.println("f="+f);
		}
		return "redirect:fruit1";
		                                                                           
	}
	

}
