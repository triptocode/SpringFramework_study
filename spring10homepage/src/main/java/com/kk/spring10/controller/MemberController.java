package com.kk.spring10.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kk.spring10.entity.MemberDto;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@GetMapping("/join")
	public String join(){	
		return "member/join";
	}	
	
	@PostMapping("/join")
	public String join(@ModelAttribute MemberDto memberDto) {
		
		MemberDto findId = sqlSession.selectOne("mnMember.siFindId", memberDto.getMember_id()); 
		if(findId==null) {
		   sqlSession.insert("mnMember.isJoin", memberDto);
		return "redirect:join_finish";
		}
		
		else { 
			return "redirect:join?error";
		}
	}
	
	@GetMapping("/join_finish")
	public String joinFinish(){
		return "member/join_?error";
	}	
}
