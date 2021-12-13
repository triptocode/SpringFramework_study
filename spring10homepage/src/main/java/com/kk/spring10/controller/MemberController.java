package com.kk.spring10.controller;

import javax.servlet.http.HttpSession;

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
		
     MemberDto findId = 
	 sqlSession.selectOne("mnMember.siFindId", memberDto.getMember_id()); 
		
     if(findId==null) {
		   sqlSession.insert("mnMember.isJoin", memberDto);
		return "redirect:join_finish";
		}
		
	 else { return "redirect:join?error"; }
	}
	
	@GetMapping("/join_finish")
	public String joinFinish(){
		return "member/join_?error";
	}	
	
	@GetMapping("/login")
	public String login() {
		
		return "member/login";
	}
	
	@PostMapping("/login")
	public String login( @ModelAttribute MemberDto memberDto, 
			HttpSession session) {
	
// 첫번째 로그인 성공시, 실패시  메소드 
// result >0 크면 로그인 성공 (저장된 디비의 id,pw와 함께 로그인시 (결과화면: result=1)성공
//		int result =sqlSession.selectOne("mnMember.siLogin1", memberDto);
//		System.out.println("result="+result);
//		return "redirect:/";  // localhost:8080/spring10, 즉 홈 메인화면으로 돌아옴

// 두번째 	로그인 성공시, 실패시    - HomeController와  root.jsp 함께보기 
		MemberDto find = 
				sqlSession.selectOne("mnMember.siLogin2", memberDto);
		if(find!=null) {//성공
		session.setAttribute("userinfo", find);
		return "redirect:/"; // 성공하면 역슬러시 / = 즉, 메인 home화면으로 돌아옴
		}
		else {//실패
			return "redirect:login?error"; //로그인화면으로 다시 돌아옴 
		}
	}		
}
	


