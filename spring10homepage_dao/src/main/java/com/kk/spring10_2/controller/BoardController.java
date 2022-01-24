package com.kk.spring10_2.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kk.spring10_2.entity.BoardDto;
import com.kk.spring10_2.repository.BoardDao;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private BoardDao boardDao;

	@GetMapping("/list")
	public String boardList(Model model)
	
	{ List<BoardDto> listBoardDto =
	         sqlSession.selectList("mnBoard.siBoardList");
	model.addAttribute("jspListBoardDto",listBoardDto);
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
		Map<String, String> map = new HashMap<>();
		map.put("type",type);
		map.put("keyword", keyword);
		List<BoardDto> listBoardDto = 
				sqlSession.selectList("mnBoard.siBoardSearch",map);
        model.addAttribute("jspListBoardDto", listBoardDto);
		// Controller model의 key값 "jspListBoardDto"는 
        // JSP파일 items= "${modelList}"와 일치해야 맵핑된다. ;
		return "board/list";
	}
	
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
		List<BoardDto> listBoardDto = sqlSession.selectList("mnBoard.siListSearch",map);
        model.addAttribute("jspListBoardDto", listBoardDto);
		
		return "board/list";
	}
	
	// 글 작성
	@GetMapping("/write")
	public String write() {
		return "board/write";
	}
	@PostMapping("/write")
	public String write(
			@ModelAttribute BoardDto boardDto,
			//이 도구는 redirect 시 파라미터를 첨부하는 역할을 한다
			RedirectAttributes redirectAttr) 
	{		
		int no = boardDao.write(boardDto);			
		redirectAttr.addAttribute("board_no", no);
		return "redirect:content";
	}
	
	
	@GetMapping("/content")
	public String content(
			@RequestParam int board_no,
			Model model) {
		BoardDto boardDto = boardDao.viewUp(board_no);
		model.addAttribute("ContentJspBoardDto", boardDto);		
		return "board/content";
	}
	
}
