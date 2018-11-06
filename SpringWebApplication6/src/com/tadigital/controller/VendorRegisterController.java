package com.tadigital.controller;

import javax.servlet.http.HttpServletRequest;

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
	
private VendorService vendorservice;
	
	@Autowired
	public VendorRegisterController(VendorService vendorservice) {
		this.vendorservice = vendorservice;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String registration() {
		return "html/registration.html";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String registerTask(@ModelAttribute Vendor vendor ,HttpServletRequest request) {
		
		boolean status = vendorservice.registerService(vendor);
		
		if(!status) {
			return "failure.jsp";
		}else {
		
			return "success.jsp";
		}
		
	}

}
