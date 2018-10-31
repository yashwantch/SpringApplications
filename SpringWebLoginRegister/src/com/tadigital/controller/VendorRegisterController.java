package com.tadigital.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tadigital.entity.Vendor;
import com.tadigital.service.VendorService;

public class VendorRegisterController {
	
private VendorService vendorservice;
	
	@Autowired
	public VendorRegisterController(VendorService vendorservice) {
		this.vendorservice = vendorservice;
	}
	
	@RequestMapping(value="register", method = RequestMethod.POST)
	public String registerTask(HttpServletRequest request) {
		
		Vendor vendor = new Vendor();
		vendor.setEmail(request.getParameter("f2"));
		vendor.setName(request.getParameter("f1"));
		vendor.setPassword(request.getParameter("f3"));
		
		boolean status = vendorservice.registerService(vendor);
		
		if(!status) {
			return "failure.jsp";
		}else {
		
			return "success.jsp";
		}
		
	}

}
