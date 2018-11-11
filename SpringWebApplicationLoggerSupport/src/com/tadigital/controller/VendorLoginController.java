package com.tadigital.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
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
	
	private static final  Logger LOGGER = Logger.getLogger("VendorLoginController excecution"); 

	private VendorService vendorservice;
	
	@Autowired
	public VendorLoginController(VendorService vendorservice) {
		this.vendorservice = vendorservice;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String loginform() {
		
		LOGGER.info("VendorLoginController : loginform  method : execution started");
		
		LOGGER.info("VendorLoginController : loginform  method : execution ended");


		return "html/login.html";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String loginTask(@ModelAttribute Vendor vendor, HttpServletRequest request) {
		
		LOGGER.info("VendorLoginController : loginTask  method : execution started");

		
		Vendor status = vendorservice.loginService(vendor);
		
		if(status == null) {
			
			LOGGER.info("VendorLoginController : loginTask  method : execution ended");
			
			return "failure.jsp";
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("VendorDetails", status);
			
			LOGGER.info("VendorLoginController : loginTask  method : execution ended");
		
			return "loginsuccess.jsp";
		}
		
	}
}
