package com.kk.spring10.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kk.spring10.entity.MemberDto;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@GetMapping("/list")
	public String adminList(Model model) { 
		List<MemberDto> mlist = sqlSession.selectList("mnMember.siMemberList");
		model.addAttribute("modelList", mlist);

		return "admin/list";
	}
	
	
	
	

}
