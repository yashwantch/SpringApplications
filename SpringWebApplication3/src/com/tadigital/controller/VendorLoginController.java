package com.tadigital.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;
import com.tadigital.entity.Vendor;
import com.tadigital.service.VendorService;

@Controller
public class VendorLoginController {

	private VendorService vendorservice;
	
	@Autowired
	public VendorLoginController(VendorService vendorservice) {
		this.vendorservice = vendorservice;
	}
	
	@RequestMapping(value="login", method = RequestMethod.POST)
	public String registerTask(@RequestParam("f2")String email, @RequestParam String f3, HttpServletRequest request) {
		
		Vendor vendor = new Vendor();
		
		vendor.setEmail(email);	
		vendor.setPassword(f3);
		
		boolean status = vendorservice.loginService(vendor);
		
		if(!status) {
			return "failure.jsp";
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("VendorDetails", vendor);
		
			return "loginsuccess.jsp";
		}
		
	}
}
