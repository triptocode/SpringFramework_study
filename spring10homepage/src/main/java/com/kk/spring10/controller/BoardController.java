package com.kk.spring10.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	// 위의 key값 "modelList"는 JSP파일 items= "${modelList}"와 일치해야 맵핑된다. 
	return "board/list";
	}
	
	
	// DTO에 없는 객체 (type = 제목, 작성자 / keyword =검색어)를 받기 위해 @RequestParam 을 활용
	// String은 하나만 받을때, Map 으로 두개이상 받을수 있게 한다. 
	//( controller boardSearch 메서드, mapper의 resultType 모두 map)
	@PostMapping("/search")
	public String boardSearch(@RequestParam String type, 
			                  @RequestParam String keyword,
			                  Model model
			                  ) {
		Map<String, String> param = new HashMap<>();
		param.put("type",type);
		param.put("keyword", keyword);
		List<BoardDto> blist2 = sqlSession.selectList("mnBoard.siBoardSearch",param);
        model.addAttribute("modelList", blist2);
		// 위의 key값 "modelList"는 JSP파일 items= "${modelList}"와 일치해야 맵핑된다. ;
		return "board/list";
	}
	

}
