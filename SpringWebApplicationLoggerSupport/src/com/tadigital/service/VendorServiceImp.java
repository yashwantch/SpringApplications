package com.tadigital.service;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tadigital.dao.VendorDao;
import com.tadigital.entity.Vendor;

@Service
public class VendorServiceImp implements VendorService {
	
	private static final  Logger LOGGER = Logger.getLogger("VendorService excecution"); 
	
	private VendorDao vendordao;

	@Autowired
	public VendorServiceImp(VendorDao vendordao) {
		
		this.vendordao = vendordao;
	}
	
	@Override
	public Vendor loginService(Vendor vendor) {
		
		LOGGER.info("VendorService : loginService  method : execution started");

		Vendor v1 =  vendordao.login(vendor);
		
		LOGGER.info("VendorService : loginService  method : execution ended");
		
		return v1;
	}

	@Override
	public boolean registerService(Vendor vendor) {
		
		LOGGER.info("VendorService : registerService  method : execution started");
		
		boolean b1 =  vendordao.register(vendor);
		
		LOGGER.info("VendorService : registerService  method : execution ended");
		
		return b1;
	}

	@Override
	public List<Vendor> selectAllUsers() {
		
		LOGGER.info("VendorService : selectAllUsers  method : execution started");
	
		List<Vendor> l1 =  vendordao.allUsers();
		
		LOGGER.info("VendorService : selectAllUsers  method : execution ended");
		
		return l1;
	}

	@Override
	public boolean vendorDelete(int id) {
		
		LOGGER.info("VendorService : vendorDelete  method : execution started");
		
		boolean b1 = vendordao.deleteVendor(id);
		
		LOGGER.info("VendorService : vendorDelete  method : execution ended");
		
		return b1;
	}

	@Override
	public boolean updateVendor(Vendor v) {
		
		LOGGER.info("VendorService : updateVendor  method : execution started");
		
		boolean b1 = vendordao.updateVendor(v);
		
		LOGGER.info("VendorService : updateVendor  method : execution ended");
		
		return b1;
	}

	@Override
	public Vendor editVendor(int vid) {
		
		LOGGER.info("VendorService : editVendor  method : execution started");

		Vendor v1 =  vendordao.editVendor(vid);
		
		LOGGER.info("VendorService : editVendor  method : execution started");

		return v1;
	}

}
