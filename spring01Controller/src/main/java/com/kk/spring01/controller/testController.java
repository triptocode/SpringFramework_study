package com.kk.spring01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testController {

@RequestMapping(value="/front1")
public String home1 () {
return "/WEB-INF/views/test1.jsp"; 
// 1.문제:return: view 폴더안에 jsp 연결경로가 길다. ( viewResolver 사용x  )
} 
	
@RequestMapping(value="/front2")
public String home2 () {
return "test2"; 
// 2.해결: (viewResolver 사용 o ) 
// servlet-context:  prefix, suffix jsp연결주소 간략화함
}
}
