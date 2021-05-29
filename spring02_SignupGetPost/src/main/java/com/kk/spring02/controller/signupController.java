package com.kk.spring02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member")  // 공용주소 

public class signupController {
	
//	@RequestMapping("/signup") 한 주소에 
// 가입과 완료 두가지 jsp의 view화면을 GET,POST 를 사용하여 보여주기
	
	@RequestMapping(value="/signup", method= RequestMethod.GET)
	
	public String signup1() {
		return"join";
	}
	
	// 같은 하나의 url 경로 /signup 에 두가지 모두 보여줄때 GET, POST 사용
	
	@RequestMapping	(value= "/signup", method=RequestMethod.POST)
	public String signup2() {
		return "welcome";
	}		
	}
	
