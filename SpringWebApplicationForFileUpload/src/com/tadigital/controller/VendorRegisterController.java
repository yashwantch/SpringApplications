package com.tadigital.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		return "html/registration.html";
	}
	
	@PostMapping(value = "/registration")
	public String registerTask(@ModelAttribute Vendor vendor, @RequestParam("img1") Part part) {
		
		vendor.setPart(part);
		
		boolean status = vendorservice.registerService(vendor);
		
		if(!status) {
			return "WEB-INF/views/failure.jsp";
		}else {
		
			return "WEB-INF/views/success.jsp";
		}
		
	}

}
