package com.tadigital.dao;

import java.util.List;

import com.tadigital.entity.Vendor;

public interface VendorDao {
	
	public boolean register(Vendor vendor);
	public boolean login(Vendor vendor);
	public List<Vendor> allUsers();
	public boolean deleteVendor(int id);

}
