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
		Map<String, String> param = new HashMap<>();
		param.put("type",type);
		param.put("keyword", keyword);
		List<BoardDto> boardList2 = 
				sqlSession.selectList("mnBoard.siBoardSearch",param);
        model.addAttribute("modelList", boardList2);
		// ���� key�� "modelList"�� JSP���� items= "${modelList}"�� ��ġ�ؾ� ���εȴ�. ;
		return "board/list";
	}
	
	//
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
		List<BoardDto> boardList3 = sqlSession.selectList("mnBoard.siListSearch",map);
        model.addAttribute("modelList", boardList3);
		
		return "board/list";
	}
	
	

}
