package com.tadigital.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tadigital.entity.Vendor;
import com.tadigital.service.VendorService;

@Controller
public class VendorDeleteController {
	
	private static final  Logger LOGGER = Logger.getLogger("VendorDeleteController excecution"); 

	
	private VendorService vendorServiceProxy;
	
	@Autowired
	public VendorDeleteController(VendorService vendorServiceProxy) {
		this.vendorServiceProxy = vendorServiceProxy;
	}
	
	@RequestMapping(value = "/delete{vid}")
	public String delete(@PathVariable int vid, HttpSession session) {
		
		LOGGER.info("VendorDeleteController : delete  method : execution started");
	
		
		 boolean status = vendorServiceProxy.vendorDelete(vid);
			
			if (status) {
				
				ArrayList<Vendor> list = (ArrayList<Vendor>) vendorServiceProxy.selectAllUsers();
				
				session.setAttribute("VENDORLIST", list);
				
				LOGGER.info("VendorDeleteController : delete  method : execution ended");
				
		  		return "VendorList.jsp"; 
			}
			LOGGER.info("VendorDeleteController : delete  method : execution ended");
		return null;
		
	}

}
