package com.tadigital.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tadigital.entity.Vendor;
import com.tadigital.service.VendorService;

@Controller
@RequestMapping(value = "/registration")
public class VendorRegisterController {
	
	private static final  Logger LOGGER = Logger.getLogger("VendorRegisterController excecution"); 

	private VendorService vendorservice;
	
	@Autowired
	public VendorRegisterController(VendorService vendorservice) {
		this.vendorservice = vendorservice;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String registration() {
		
		LOGGER.info("VendorRegisterController : loginTask  method : execution started");

		return "html/registration.html";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String registerTask(@ModelAttribute Vendor vendor ,HttpServletRequest request) {
		
		LOGGER.info("VendorRegisterController : registerTask  method : execution started");

		
		boolean status = vendorservice.registerService(vendor);
		
		if(!status) {
			
			LOGGER.info("VendorRegisterController : registerTask  method : execution ended");
			
			return "failure.jsp";
		}else {
			
			LOGGER.info("VendorRegisterController : registerTask  method : execution ended");
		
			return "success.jsp";
		}
		
	}

}
