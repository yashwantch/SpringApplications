package com.tadigital.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tadigital.entity.Vendor;
import com.tadigital.service.VendorService;

@Controller
public class VendorListController {
	
	private static final  Logger LOGGER = Logger.getLogger("VendorListController excecution"); 

	
	private VendorService vendorServiceProxy; 
	 
	 
		@Autowired
	  	public VendorListController(VendorService vendorServiceProxy) { 
	  		this.vendorServiceProxy = vendorServiceProxy; 
	  	} 
	  
	 
	  	@RequestMapping(value = "/vendorList") 
	  	public String allUsers(HttpServletRequest request) { 
	  		
			LOGGER.info("VendorListController : allUsers  method : execution started");

	  		
	  		ArrayList<Vendor> list = (ArrayList<Vendor>) vendorServiceProxy.selectAllUsers(); 
	  		HttpSession httpSession = request.getSession(); 
	  		httpSession.setAttribute("VENDORLIST", list); 
	  		
			LOGGER.info("VendorListController : allUsers  method : execution ended");

	  		return "VendorList.jsp"; 
	  	}
	  	
	  	@RequestMapping(value = "/edit{vid}")
		public String editVendor(@PathVariable int vid, HttpSession session) {
	  		
			LOGGER.info("VendorListController : editVendor  method : execution started");


			Vendor v = vendorServiceProxy.editVendor(vid);

			if(v == null) {
				
				LOGGER.info("VendorListController : editVendor  method : execution ended");

				return "vendorList.jsp";

			}

			session.setAttribute("EDIT_VENDOR", v);

			return "EditForm.jsp";

		}
	  	
	  	@RequestMapping(value = "/updateVendor")
		public String updateVendor(HttpServletRequest req,HttpSession session) {
	  		
			LOGGER.debug("VendorListController : updateVendor  method : execution started");


			Vendor v = (Vendor)session.getAttribute("EDIT_VENDOR");

			v.setName(req.getParameter("name"));

			v.setEmail(req.getParameter("email"));
			v.setPassword(req.getParameter("password"));

			if(vendorServiceProxy.updateVendor(v)) {

				
				LOGGER.debug("VendorListController : updateVendor  method : execution ended");


				return "vendorList";

			}
			
			LOGGER.debug("VendorListController : updateVendors  method : execution ended");


			return "editForm.jsp";

		}


}
