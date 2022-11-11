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
	// ȸ������ ������ ����
	@GetMapping("/join")
	public String join(){	
		return "member/join";
	}
	// ȸ�������������� <form>���� �����͸� input �޾Ƽ� ���ö� post ó��
	@PostMapping("/join")
	public String join(@ModelAttribute MemberDto memberDto) {
		boolean result = memberDao.join(memberDto);
		if(result) {return "redirect:join_finish"; }
		else {return "redirect:join?error";}
	}	
	// ȸ�������� �Ϸ� ������
	@GetMapping("/join_finish")
	public String joinFinish(){return "member/join_finish";}	
		
	// �α��� ȭ�� ��������, 
	@GetMapping("/loginUrl")
	public String login() {return "member/login";}
	// �α��� ȭ�鿡�� id, pw ������ �Է¹����� DB�� ���� id, pw �´��� ���ο� ���� ó�� (1.�����ϸ� Ȩ����, 2.�����ϸ� ����ó��) 
	@PostMapping("/loginUrl")
	public String login(@ModelAttribute MemberDto memberDto,HttpSession session) { 
		// if(�α��� true �����ϸ�)
		if(memberDao.login(memberDto)) {
			MemberDto find = memberDao.get(memberDto.getMember_id());
			session.setAttribute("userinfo", find);
			return "redirect:/";   // Ȩ���� 
		}
		//�� ���� ��� ���� ������ ����
		else {return "redirect:loginUrl?error";  // ����������
		}
	}
}