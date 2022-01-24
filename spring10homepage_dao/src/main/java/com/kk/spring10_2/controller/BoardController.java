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
	// ���� key�� "modelList"�� JSP���� items= "${modelList}"�� ��ġ�ؾ� ���εȴ�. 
	return "board/list";
	}
	
	
	// DTO�� ���� ��ü (type = ����, �ۼ��� / keyword =�˻���)�� �ޱ� ���� @RequestParam �� Ȱ��
	// String�� �ϳ��� ������, Map ���� �ΰ��̻� ������ �ְ� �Ѵ�. 
	//( controller boardSearch �޼���, mapper�� resultType ��� map)
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
		// Controller model�� key�� "jspListBoardDto"�� 
        // JSP���� items= "${modelList}"�� ��ġ�ؾ� ���εȴ�. ;
		return "board/list";
	}
	
	// ��ȸ �� �˻� ���� ���� : �˻��� ���Ҽ��� ������ required=false ���۵� if �����߰� 
	// Map<String, String> , Map<String, Object> ��� �� �۵�
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
	
	// �� �ۼ�
	@GetMapping("/write")
	public String write() {
		return "board/write";
	}
	@PostMapping("/write")
	public String write(
			@ModelAttribute BoardDto boardDto,
			//�� ������ redirect �� �Ķ���͸� ÷���ϴ� ������ �Ѵ�
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
