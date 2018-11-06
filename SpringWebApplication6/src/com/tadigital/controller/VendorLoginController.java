package com.tadigital.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;
import com.tadigital.entity.Vendor;
import com.tadigital.service.VendorService;

@Controller
@RequestMapping(value = "/login")
public class VendorLoginController {

	private VendorService vendorservice;
	
	@Autowired
	public VendorLoginController(VendorService vendorservice) {
		this.vendorservice = vendorservice;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String loginform() {
		return "html/login.html";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String registerTask(@ModelAttribute Vendor vendor, HttpServletRequest request) {
		
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
