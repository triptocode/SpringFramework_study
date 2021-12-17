package com.kk.spring10_2.controller;
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

import com.kk.spring10_2.entity.BoardDto;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private SqlSession sqlSession;

	@GetMapping("/list")
	public String boardList(Model model)
	
	{ List<BoardDto> boardList =
	         sqlSession.selectList("mnBoard.siBoardList");
	model.addAttribute("modelList",boardList);
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
		List<BoardDto> boardList2 = 
				sqlSession.selectList("mnBoard.siBoardSearch",param);
        model.addAttribute("modelList", boardList2);
		// 위의 key값 "modelList"는 JSP파일 items= "${modelList}"와 일치해야 맵핑된다. ;
		return "board/list";
	}
	
	//
	// 조회 및 검색 통합 구현 : 검색은 안할수도 있으니 required=false 매퍼도 if 조건추가 
	// Map<String, String> , Map<String, Object> 모두 잘 작동
	@RequestMapping("/listSearch")
	public String listAndSearch (@RequestParam (required=false)String type, 
			                  @RequestParam (required=false)String keyword,
			                  Model model
			                  ) {
		Map<String, Object> map = new HashMap<>();
		map.put("type",type);
		map.put("keyword", keyword);
		List<BoardDto> boardList3 = sqlSession.selectList("mnBoard.siListSearch",map);
        model.addAttribute("modelList", boardList3);
		
		return "board/list";
	}
	
	

}
