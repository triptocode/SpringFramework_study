package com.kk.spring06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/menu")
public class MenuController {
	@Autowired
	private JdbcTemplate jdbcTemplate;	
	
@GetMapping("/insert")
public String insert() {
	System.out.println(jdbcTemplate);
	return "menu/insert"; }

@PostMapping("/insert")
public String insert(
		@RequestParam String name,
		@RequestParam int price) {
//	System.out.println("name = " + name);
//	System.out.println("price = " + price);		
	String sql = "INSERT INTO menu VALUES(?, ?)";
	Object[] param = {name, price}; // new Object{name, price}; µµ °¡´É
	jdbcTemplate.update(sql, param);	

	//	return "redirect:insert";
	return "redirect:/menu/insert";
}

}
