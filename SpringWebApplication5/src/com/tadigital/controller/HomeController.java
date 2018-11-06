package com.tadigital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	

	@RequestMapping(value = {"/", "/home"})
	public String index() {
		return "html/index.html";
	}
	
	@RequestMapping(value = "/loginform")
	public String loginform() {
		return "html/loginform.html";
	}
	
	@RequestMapping(value = "/registration")
	public String registration() {
		return "html/registration.html";
	}
}
