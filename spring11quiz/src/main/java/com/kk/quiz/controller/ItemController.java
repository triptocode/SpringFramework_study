package com.kk.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kk.quiz.entity.ItemDto;
import com.kk.quiz.repository.ItemDao;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemDao itemDao;
	
	@GetMapping("/")
	public String home() {
		
		return "item/home";
	}
	
	@GetMapping("/add")
	public String add() {
		
		return "item/add";
	}
	
	@PostMapping("/add")
	public String add(@ModelAttribute ItemDto itemDto) {
                      // requestMapping�� ������� ������ �������� ������
	                  //ModelAttribute�� �ѹ����� ��� �޴� ������
		itemDao.insert(itemDto);
		return "redirect:list";
	}
	
}