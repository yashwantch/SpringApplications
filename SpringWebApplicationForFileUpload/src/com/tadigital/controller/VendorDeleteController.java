package com.tadigital.controller;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.tadigital.entity.Vendor;
import com.tadigital.service.VendorService;

@Controller
public class VendorDeleteController {
	
	private VendorService vendorservice;
	
	@Autowired
	public VendorDeleteController(VendorService vendorservice) {
		this.vendorservice = vendorservice;
	}
	
	@GetMapping(value = "/delete{vid}")
	public String delete(@PathVariable int vid, HttpSession session) {
	
		
		 boolean status = vendorservice.vendorDelete(vid);
			
			if (status) {
				
				ArrayList<Vendor> list = (ArrayList<Vendor>) vendorservice.selectAllUsers(); 
				session.setAttribute("VENDORLIST", list); 
		  		return "WEB-INF/views/VendorList.jsp"; 
			}
		return null;
		
	}

}
