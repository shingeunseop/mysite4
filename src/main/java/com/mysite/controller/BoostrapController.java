package com.mysite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoostrapController {
	
	@RequestMapping(value="/boot")
	public String boot() {
		return "bootstrap/index";
	}

}
