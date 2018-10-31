package com.tadigital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tadigital.dao.VendorDao;
import com.tadigital.entity.Vendor;

@Service
public class VendorServiceImp implements VendorService {
	
	private VendorDao vendordao;

	@Autowired
	public VendorServiceImp(VendorDao vendordao) {
		this.vendordao = vendordao;
	}
	
	@Override
	public boolean loginService(Vendor vendor) {
		return vendordao.login(vendor);
	}

	@Override
	public boolean registerService(Vendor vendor) {
		
		return vendordao.register(vendor);
	}

}
