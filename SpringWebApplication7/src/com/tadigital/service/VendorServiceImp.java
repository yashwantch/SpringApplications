package com.tadigital.service;

import java.util.List;

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
	public Vendor loginService(Vendor vendor) {
		return vendordao.login(vendor);
	}

	@Override
	public boolean registerService(Vendor vendor) {
		
		return vendordao.register(vendor);
	}

	@Override
	public List<Vendor> selectAllUsers() {
		return vendordao.allUsers();
	}

	@Override
	public boolean vendorDelete(int id) {
		return vendordao.deleteVendor(id);
	}

	@Override
	public boolean updateVendor(Vendor v) {
		return vendordao.updateVendor(v);
	}

	@Override
	public Vendor editVendor(int vid) {
		return vendordao.editVendor(vid);
	}

}
