package com.tadigital.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.tadigital.entity.Vendor;
import com.tadigital.service.VendorService;

@Controller

public class VendorRegisterController {
	
private VendorService vendorservice;
	
	@Autowired
	public VendorRegisterController(VendorService vendorservice) {
		this.vendorservice = vendorservice;
	}
	
	@GetMapping(value = "/registration")
	public String registration() {
		return "registrationform";
	}
	
	@PostMapping(value = "/registration")
	public String registerTask(@ModelAttribute Vendor vendor ,HttpServletRequest request) {
		
		boolean status = vendorservice.registerService(vendor);
		
		if(!status) {
			return "registrationfailure";
		}else {
		
			return "registrationsuccess";
		}
		
	}

}
