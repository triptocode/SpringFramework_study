package com.kk.spring07.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kk.spring07.entity.StudentDto;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired//�̸� ����� �������� �ڵ����� �����ض�!
	private SqlSession sqlSession;
	
	@GetMapping("/regist")
	public String regist() {
//		return "/WEB-INF/views/student/regist.jsp";
		return "student/regist";
	}
	
	@PostMapping("/regist")
	public String regist(@ModelAttribute StudentDto st) {
		//�����ͺ��̽� ��� 
		// = mybatis�� sqlSession�� �̿��Ͽ� mapper ȣ�� �� ����
		// sqlSession.insert("�����̸�", ������);
		sqlSession.insert("mn.i", st); //( mn =mapper-namespcae , i=id)
		return "redirect:regist";
	}
	
}





