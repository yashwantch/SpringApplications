package com.tadigital.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	  		return "WEB-INF/views/VendorList.jsp"; 
	  	}
	  	
	  	@RequestMapping(value = "/edit{vid}")
		public String editVendor(@PathVariable int vid, HttpSession session) {

			Vendor v = vendorService.editVendor(vid);

			if(v == null) {

				return "WEB-INF/views/vendorList.jsp";

			}

			session.setAttribute("EDIT_VENDOR", v);

			return "WEB-INF/views/EditForm.jsp";

		}
	  	
	  	@RequestMapping(value = "/updateVendor")
		public String updateVendor(HttpServletRequest req,HttpSession session) {

			Vendor v = (Vendor)session.getAttribute("EDIT_VENDOR");

			v.setName(req.getParameter("name"));

			v.setEmail(req.getParameter("email"));
			v.setPassword(req.getParameter("password"));

			if(vendorService.updateVendor(v)) {

				session.setAttribute("VendorDetails", v);

				return "vendorList";

			}

			return "WEB-INF/views/editForm.jsp";

		}


}
