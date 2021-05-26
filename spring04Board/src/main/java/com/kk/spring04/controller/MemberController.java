package com.kk.spring04.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kk.spring04.entity.MemberDto;

@Controller 
@RequestMapping("/member")
public class MemberController {
	
	//@RequestMapping(value="/signup", method=RequestMethod.GET) 
	@GetMapping("/signup")
  public String join1(){
		return "member/join"; }

	
    @PostMapping("/signup2")
   public String join2(@ModelAttribute MemberDto mdto1) {	   
	    System.out.println("아이디"+mdto1.getId());
		System.out.println("패스워드"+mdto1.getPw());
		System.out.println("닉네임 " +mdto1.getNick());
		return "welcome"; }
 
 @GetMapping("/login1")
 public String login() {
	 return "member/login";	 }
 
 @PostMapping("/login2")
	public String login(@ModelAttribute MemberDto mdto2) {
		System.out.println("id = "  + mdto2.getId());
		System.out.println("pw = " + mdto2.getPw());
		return "redirect:/"; // 최상위로 보낸 주소가 url에 나오고, 성공시 아직 페이지 안만들어서 404	
 }
}

 
 

