package com.tadigital.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String registerTask(@RequestParam String f2, @RequestParam String f1, @RequestParam String f3, HttpServletRequest request) {
		
		Vendor vendor = new Vendor();
		vendor.setEmail(f2);
		vendor.setName(f1);
		vendor.setPassword(f3);
		
		boolean status = vendorservice.registerService(vendor);
		
		if(!status) {
			return "failure.jsp";
		}else {
		
			return "success.jsp";
		}
		
	}

}
