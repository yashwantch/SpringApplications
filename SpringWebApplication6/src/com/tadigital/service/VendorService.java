package com.tadigital.service;

import java.util.ArrayList;
import java.util.List;

import com.tadigital.entity.Vendor;

public interface VendorService {
	
	public boolean loginService(Vendor vendor);
	public boolean registerService(Vendor vendor);
	public List<Vendor> selectAllUsers();
	public boolean vendorDelete(int id);

}
