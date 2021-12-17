package com.kk.spring10_2.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kk.spring10_2.entity.MemberDto;
import com.kk.spring10_2.repository.MemberDao;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberDao memberDao;

	
	@GetMapping("/join")
	public String join(){	
		return "member/join";
	}	
	
	@PostMapping("/join")
public String join(@ModelAttribute MemberDto memberDto) {
		boolean result = memberDao.join(memberDto);
		if(result) {
			return "redirect:join_finish";
		}
		else {
			return "redirect:join?error";
		}
	}
	
	
	@GetMapping("/join_finish")
	public String joinFinish(){
		return "member/join_finish";
}	
	
	// 로그인 화면 보여준후, 
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("/login")
	public String login(
			@ModelAttribute MemberDto memberDto,
			HttpSession session) {
        
		// if(로그인 true 성공하면)
		if(memberDao.login(memberDto)) {
			MemberDto find = memberDao.get(memberDto.getMember_id());
			session.setAttribute("userinfo", find);
			return "redirect:/";   // 홈으로 
		}
		//그 외의 모든 경우는 오류로 간주
		else {
			return "redirect:login?error";  // 오류페이지
		}
	}
}