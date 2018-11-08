package com.tadigital.service;

import java.util.List;

import com.tadigital.entity.Vendor;

public interface VendorService {
	
	public Vendor loginService(Vendor vendor);
	public boolean registerService(Vendor vendor);
	public List<Vendor> selectAllUsers();
	public boolean vendorDelete(int id);
	public boolean updateVendor(Vendor v);
	public Vendor editVendor(int vid);

}
