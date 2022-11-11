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
	// 회원가입 페이지 진입
	@GetMapping("/join")
	public String join(){	
		return "member/join";
	}
	// 회원가입페이지의 <form>에서 데이터를 input 받아서 들어올때 post 처리
	@PostMapping("/join")
	public String join(@ModelAttribute MemberDto memberDto) {
		boolean result = memberDao.join(memberDto);
		if(result) {return "redirect:join_finish"; }
		else {return "redirect:join?error";}
	}	
	// 회원가입후 완료 페이지
	@GetMapping("/join_finish")
	public String joinFinish(){return "member/join_finish";}	
		
	// 로그인 화면 보여준후, 
	@GetMapping("/loginUrl")
	public String login() {return "member/login";}
	// 로그인 화면에서 id, pw 데이터 입력받은후 DB에 기존 id, pw 맞는지 여부에 따른 처리 (1.성공하면 홈으로, 2.실패하면 오류처리) 
	@PostMapping("/loginUrl")
	public String login(@ModelAttribute MemberDto memberDto,HttpSession session) { 
		// if(로그인 true 성공하면)
		if(memberDao.login(memberDto)) {
			MemberDto find = memberDao.get(memberDto.getMember_id());
			session.setAttribute("userinfo", find);
			return "redirect:/";   // 홈으로 
		}
		//그 외의 모든 경우는 오류로 간주
		else {return "redirect:loginUrl?error";  // 오류페이지
		}
	}
}