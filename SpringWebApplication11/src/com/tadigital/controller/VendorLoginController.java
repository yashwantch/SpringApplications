package com.tadigital.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.tadigital.entity.Vendor;
import com.tadigital.service.VendorService;

@Controller
public class VendorLoginController {

	private VendorService vendorservice;
	
	@Autowired
	public VendorLoginController(VendorService vendorservice) {
		this.vendorservice = vendorservice;
	}
	
	@GetMapping(value = "/login")
	public String loginform() {
		return "html/login.html";
	}
	
	@PostMapping(value = "/login")
	public String registerTask(@ModelAttribute Vendor vendor, HttpServletRequest request) {
		
		Vendor status = vendorservice.loginService(vendor);
		
		if(status == null) {
			return "failure.jsp";
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("VendorDetails", status);
		
			return "loginsuccess.jsp";
		}
		
	}
}
