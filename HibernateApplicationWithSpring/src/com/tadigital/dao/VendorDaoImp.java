package com.tadigital.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.tadigital.entity.Vendor;


public class VendorDaoImp implements VendorDao {

	private SessionFactory sessionFactory;
	
	
	 public VendorDaoImp(SessionFactory sf) {
		this.sessionFactory = sf;
	 }

	@Override
	public boolean register(Vendor vendor) {
		

		boolean status = false;
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		session.save(vendor);
		
		transaction.commit();
		
		status = true;
		
		session.close();
		
		return status;
	}

	@Override
	public Vendor login(Vendor vendor) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Vendor v = null;
		
		String hql = "FROM Vendor v WHERE v.email='" + vendor.getEmail() + "' AND v.password='" + vendor.getPassword() + "'";
		
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Vendor> vendors = query.list();
		
		if(!vendors.isEmpty()) {
			
			
			 v = vendors.get(0);
			
		}
		
		transaction.commit();
		session.close();
		
		return v;

	}

	@Override
	public List<Vendor> allUsers() {

		
Session session = sessionFactory.openSession();
		
		String hql = "FROM Vendor";
		
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Vendor> vendors = query.list();
		
		List<Vendor> vendorList = new ArrayList<>(vendors);
		
		session.close();
		
		return vendorList;
	}

	@Override
	public boolean deleteVendor(int id ) {
	
		boolean status = false;

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Vendor vendor = session.get(Vendor.class, id);
		if(vendor != null) {
			session.delete(vendor);
			
			transaction.commit();
			status = true;
		}
		
		session.close();
		
		return status;
		
	}

	@Override
	public boolean updateVendor(Vendor v) {
		
		boolean status = false;
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.update(v);
			
		transaction.commit();
		status = true;
		
		session.close();
		
		return status;
	}

	@Override
	public Vendor editVendor(int vid) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Vendor v = session.get(Vendor.class, vid);
		
		transaction.commit();
		
		session.close();
	
		return v;
	}

}
