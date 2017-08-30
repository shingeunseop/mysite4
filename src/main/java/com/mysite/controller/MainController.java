package com.mysite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping(value="/main")
	public String main() {
		
		
		return "main/index";
	}//여기까지만 하면 css가 막혀있음.본래 톰캣이 하던것이나 제어권을 가져와서 세팅을 해야함(지금까지의 설계는 그것을 제어권을 가져옴)
	
//1번 ppt의 맨 마지막줄에 있는 spring의 서블릿을 넣어줘야 css가 main에 적용된다.
	
	@RequestMapping(value="/main/search")
	public String search() {
		return "main/search";
	}
	

}
