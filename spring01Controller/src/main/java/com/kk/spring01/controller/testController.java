package com.kk.spring01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testController {

@RequestMapping(value="/front1")
public String home1 () {
	return "/WEB-INF/views/test1.jsp"; // 1.문제:jsp 연결주소가 길다. ( viewResolver 코드사용 x  )
} 
	
@RequestMapping(value="/front2")
public String home2 () {
	return "test2"; // 2.해결: (viewResolver 코드 사용  o ) servlet-context 에서 prefix, suffix  jsp 연결주소를 간략화함
}


}
