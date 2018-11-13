package com.tadigital.service;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tadigital.dao.VendorDao;
import com.tadigital.entity.Vendor;

public class VendorServiceImp implements VendorService {
	
	private static final  Logger LOGGER = Logger.getLogger("VendorService excecution"); 
	
	private VendorDao vendorDaoProxy;

	public VendorServiceImp(VendorDao vendorDaoProxy) {
		
		this.vendorDaoProxy = vendorDaoProxy;
	}
	
	@Override
	public Vendor loginService(Vendor vendor) {
		
		LOGGER.info("VendorService : loginService  method : execution started");

		Vendor v1 =  vendorDaoProxy.login(vendor);
		
		LOGGER.info("VendorService : loginService  method : execution ended");
		
		return v1;
	}

	@Override
	public boolean registerService(Vendor vendor) {
		
		LOGGER.info("VendorService : registerService  method : execution started");
		
		boolean b1 =  vendorDaoProxy.register(vendor);
		
		LOGGER.info("VendorService : registerService  method : execution ended");
		
		return b1;
	}

	@Override
	public List<Vendor> selectAllUsers() {
		
		LOGGER.info("VendorService : selectAllUsers  method : execution started");
	
		List<Vendor> l1 =  vendorDaoProxy.allUsers();
		
		LOGGER.info("VendorService : selectAllUsers  method : execution ended");
		
		return l1;
	}

	@Override
	public boolean vendorDelete(int id) {
			
		return vendorDaoProxy.deleteVendor(id);	
	}

	@Override
	public boolean updateVendor(Vendor v) {
		
		return vendorDaoProxy.updateVendor(v);		
		
	}

	@Override
	public Vendor editVendor(int vid) {
		
		return  vendorDaoProxy.editVendor(vid);
	}

}
