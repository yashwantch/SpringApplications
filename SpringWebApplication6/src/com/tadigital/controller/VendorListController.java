package com.tadigital.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tadigital.entity.Vendor;
import com.tadigital.service.VendorService;

@Controller
public class VendorListController {
	
	VendorService vendorService; 
	 
	 
		@Autowired
	  	public VendorListController(VendorService vendorService) { 
	  		this.vendorService = vendorService; 
	  	} 
	  
	 
	  	@RequestMapping(value = "/vendorList") 
	  	public String allUsers(HttpServletRequest request) { 
	  		
	  		ArrayList<Vendor> list = (ArrayList<Vendor>) vendorService.selectAllUsers(); 
	  		HttpSession httpSession = request.getSession(); 
	  		httpSession.setAttribute("VENDORLIST", list); 
	  		return "VendorList.jsp"; 
	  	} 


}
