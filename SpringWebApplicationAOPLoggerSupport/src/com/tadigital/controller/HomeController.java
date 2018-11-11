package com.tadigital.controller;

import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	private static final  Logger LOGGER = Logger.getLogger("HomeController excecution"); 
	

	@RequestMapping(value = {"/", "/home"})
	public String index() {
		
		LOGGER.info("HomeController: index method : execution started");
		
		LOGGER.info("HomeController: index method : execution ended");

		return "html/index.html";
	}
	
	
	
	
}
