package com.kk.spring02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member")  // �����ּ� 

public class signupController {
	
//	@RequestMapping("/signup") �� �ּҿ� 
// ���԰� �Ϸ� �ΰ��� jsp�� viewȭ���� GET,POST �� ����Ͽ� �����ֱ�
	
	@RequestMapping(value="/signup", method= RequestMethod.GET)
	
	public String signup1() {
		return"join";
	}
	
	// ���� �ϳ��� url ��� /signup �� �ΰ��� ��� �����ٶ� GET, POST ���
	
	@RequestMapping	(value= "/signup", method=RequestMethod.POST)
	public String signup2() {
		return "welcome";
	}		
	}
	
