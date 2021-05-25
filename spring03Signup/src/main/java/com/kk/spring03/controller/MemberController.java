package com.kk.spring03.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kk.spring03.entity.MemberDto;

@Controller 
@RequestMapping("/member")

public class MemberController {
	
	//@RequestMapping(value="/signup", method=RequestMethod.GET) 
	@GetMapping("/signup")
	public String join1(){
		return "join"; }

	
	// 방법1 	
// @PostMapping("/signup")

//	  public String join2(HttpServletRequest req) {
//      String id = req.getParameter("id");
//	    String pw = req.getParameter("pw");
//   	String nick = req.getParameter("nick");
//	
//		System.out.println("아이디"+id);
//		System.out.println("패스워드"+pw);
//		System.out.println("닉네임" + nick);
//		return "welcome";
//	}
	
      // 방법2	
//	@PostMapping("/signup")
//	public String join2(@RequestParam String id,
//			            @RequestParam String pw,
//			            @RequestParam (required = false) String nick ){ 
//	 
//	    System.out.println("아이디"+id);
//		System.out.println("패스워드"+pw);
//		System.out.println("닉네임 " + nick);
//		return "welcome";}
	
	// 방법3
	
 @PostMapping("/signup")
 public String join2(@ModelAttribute MemberDto mdto1) {
	   
	    System.out.println("아이디"+mdto1.getId());
		System.out.println("패스워드"+mdto1.getPw());
		System.out.println("닉네임 " +mdto1.getNick());

		return "welcome"; }
 
}

 
 

