package com.tadigital.dao;

import com.tadigital.entity.Vendor;

public interface VendorDao {
	
	public boolean register(Vendor vendor);
	public Vendor login(Vendor vendor);

}
