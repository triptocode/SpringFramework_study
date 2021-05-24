package com.kk.spring01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testController {

@RequestMapping(value="/front1")
public String home1 () {
return "/WEB-INF/views/test1.jsp"; 
// 1.����:jsp �����ּҰ� ���. ( viewResolver ���x  )
} 
	
@RequestMapping(value="/front2")
public String home2 () {
return "test2"; 
// 2.�ذ�: (viewResolver ��� o )servlet-context���� prefix, suffix jsp�����ּ� ����ȭ��
}
}
