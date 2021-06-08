package com.kk.spring09.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kk.spring09.entity.MenuDto;

@Controller
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private SqlSession ss;
	
	@GetMapping("/rg1")
	public String db1 () {
		return "menu/register"; }
	
	@PostMapping("/rg2")
//	public String insert(@RequestParam String name, @RequestParam int price) {
	public String db2 (@ModelAttribute MenuDto menuDto) {
		ss.insert("mn.i1", menuDto);
		return "redirect:rg1";  }
	
	@GetMapping("/list")
	public String list(Model model) {
		
		List<MenuDto> list = ss.selectList("mn.i2");
		model.addAttribute("mlist", list);
		return "menu/list"; }
}

