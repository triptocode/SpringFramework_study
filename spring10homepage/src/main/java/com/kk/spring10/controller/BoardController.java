package com.kk.spring10.controller;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kk.spring10.entity.BoardDto;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private SqlSession sqlSession;

	@GetMapping("/list")
	public String boardList(Model model)
	{ List<BoardDto> blist =sqlSession.selectList("mnBoard.siBoardList");
	model.addAttribute("modelList",blist);
	
	return "board/list";
	}
	
}
