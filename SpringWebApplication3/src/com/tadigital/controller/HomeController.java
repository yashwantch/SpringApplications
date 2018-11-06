package com.tadigital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	

	@RequestMapping(value = {"/", "/home"})
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value = "/loginform")
	public String loginform() {
		return "loginform.jsp";
	}
	
	@RequestMapping(value = "/registration")
	public String registration() {
		return "registration.jsp";
	}
}
