package com.kk.spring06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kk.spring06.entity.StudentDto;

@Controller
@RequestMapping ("/student")
public class StudentController {
	
	@Autowired
	private JdbcTemplate jt;
	
	@GetMapping("/register1")
	public String rg1() 
	{	return "student/register";
	}
	
	
	@PostMapping ("/register2")
	public String rg2( @ModelAttribute StudentDto st)
	{ String a = "insert into student values (?,?,?,sysdate)"; // student 테이블에
	  Object[] b = {st.getName(),st.getAge(),st.getScore() }; // 아래 3가지 데이터정보를 저장
	  jt.update(a, b);
	  return "redirect:register3";   //  " register3 "는 공용주소아래에 url주소넣겠다 =spring06/student/register3
	}                               //  " /register3 "는 spring06 바로뒷자리 url주소넣겠다는말 = spring06/register3
	
	@GetMapping("/register3")       
	public String rg_finish() 
	{return "student/register_finish";
	}
	
}


