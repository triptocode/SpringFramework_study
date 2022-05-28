package com.kk.spring10.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	
	@Autowired
	private PasswordEncoder encoder;
	
	@GetMapping("/join")
	public String join(){	
		return "member/join";
	}	
	
	@PostMapping("/join")
public String join(@ModelAttribute MemberDto memberDto) {
		
     MemberDto findId = 
	 sqlSession.selectOne("mnMember.siFindId", memberDto.getMember_id()); 
	         // selectOne(    query_id       ,     ����    ) query_id �� ���� select���� �����ϸ鼭 ����(���������� ����� ����)�� ����
    System.out.println(findId); 
    // null �Ǵ� 
    //com.kk.spring10.entity.MemberDto@5a97f8b1  ,  com.kk.spring10.entity.MemberDto@45f95a7
     if(findId==null) { // DB�� �ߺ��Ǵ� id�� ������ , ������ ���� pw ��ȣȭ �Ѵ�
    	 String enc = encoder.encode(memberDto.getMember_pw()); // pw ��ȣȭ
    	 memberDto.setMember_pw(enc); // ��ȣȭ�� pw ����� 
             
		   sqlSession.insert("mnMember.iiJoin", memberDto);
		return "redirect:join_finish";
		}
		
	 else { return "redirect:join?error"; }
}
	
	
	@GetMapping("/join_finish")
	public String joinFinish(){
		return "member/join_finish";
}	

	
	
	// �α��� ȭ�� ��������, 
	@GetMapping("/login")
	public String login() {
		
		return "member/login";
	}
	// �α��� ID, PW �Է½� ���� ���� �ż��� ���� 
	@PostMapping("/login")
	public String login( @ModelAttribute MemberDto memberDto, 
			HttpSession session) {
	
// ù��° ���: �α��� ������, ���н�  �޼ҵ� 
// result >0 ũ�� �α��� ���� (����� ����� id,pw�� �Բ� �α��ν� (���ȭ��: result=1)����
//		int result =sqlSession.selectOne("mnMember.siLogin1", memberDto);
//		System.out.println("result="+result);
//		return "redirect:/";  // localhost:8080/spring10, �� Ȩ ����ȭ������ ���ƿ�

// �ι�° ���: �α��� ������, ���н� �޼ҵ�  - HomeController��  root.jsp �Բ����� 
//		MemberDto find = 
//				sqlSession.selectOne("mnMember.siLogin2", memberDto);
//		if(find!=null) {//����
//		session.setAttribute("userinfo", find);
//		return "redirect:/"; // �����ϸ� �������� / = ��, ���� homeȭ������ ���ƿ�
//		}
//		else {//����
//			return "redirect:login?error"; //�α���ȭ������ �ٽ� ���ƿ� 
//		}


// ����° ��� : ȸ�����Խ� ��ȣȭ�� pw�� �α��νÿ��� ��ȣȭ�� ��ӵǾ� ���� ����ڿ��� ��ȣ�� �޶����� �����߻��Ѵ�.
		   // ���� encoder.matches �� ȭ���Ͽ� �ذ��Ѵ�.
		   // �������ʹ� �� �����ڸ� �α��ο� ����. 
		   // ������ ������ id,pw�� �α��� �Ұ������� DB���� DELETE member; commit; ���ֱ�. 
		MemberDto find = 
				sqlSession.selectOne("mnMember.siFindId", memberDto.getMember_id());
	if(find!=null) {// ����, ���̵� ������
			// ���̵� ������ ��й�ȣ �� ���� (encoder ���)
			// encoder.matches(���� �Է�pw, ��� �̹� ����� PW) --> booleanŸ��
			// �Ʒ� �޼ҵ� : ���̸� --> pass �� �� �Է�
			boolean pass = encoder.matches(
					memberDto.getMember_pw(), find.getMember_pw());
		if(pass) {
			session.setAttribute("userinfo", find);
		return "redirect:/"; // �����ϸ� �������� / = ��, ���� homeȭ������ ���ƿ�
		}
	}
	
	// ����, �� ���� ��� ���� ������ ó�� 
	return "redirect:login?error"; //�α���ȭ������ �ٽ� ���ƿ� 
		}
	}	
	

	


