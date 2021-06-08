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
	
	@Autowired//미리 등록한 도구들을 자동으로 연동해라!
	private SqlSession sqlSession;
	
	@GetMapping("/regist")
	public String regist() {
//		return "/WEB-INF/views/student/regist.jsp";
		return "student/regist";
	}
	
	@PostMapping("/regist")
	public String regist(@ModelAttribute StudentDto st) {
		//데이터베이스 등록 
		// = mybatis의 sqlSession을 이용하여 mapper 호출 및 실행
		// sqlSession.insert("구문이름", 데이터);
		sqlSession.insert("mn.i", st); //( mn =mapper-namespcae , i=id)
		return "redirect:regist";
	}
	
}





