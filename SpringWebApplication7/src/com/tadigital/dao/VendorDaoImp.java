package com.tadigital.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tadigital.entity.Vendor;

@Repository
public class VendorDaoImp implements VendorDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	 public VendorDaoImp(DataSource dataSource) {
		 jdbcTemplate = new JdbcTemplate(dataSource);
	 }

	@Override
	public boolean register(Vendor vendor) {
		boolean status = false;
		
			String sql = "INSERT INTO vendor_information(vendor_fname, vendor_email, vendor_password) " + "VALUES(?, ?, ?)";

			int rows = jdbcTemplate.update(sql, vendor.getName(), vendor.getEmail(), vendor.getPassword());
			if (rows != 0) {
				status = true;
			}
		return status;
	}

	@Override
	public Vendor login(Vendor vendor) {
				
			
		
			String sql = "SELECT * FROM vendor_information WHERE vendor_email = ? AND vendor_password = ? ";

			Vendor vendor1 ;
			try {
			 vendor1 = jdbcTemplate.queryForObject(sql, new Object[]{ vendor.getEmail(), vendor.getPassword()}, new RowMapper<Vendor>() {

				@Override
				public Vendor mapRow(ResultSet rs, int arg1) throws SQLException {
					Vendor vendor = new Vendor();
	  				vendor.setId(rs.getInt(1));
	  				vendor.setName(rs.getString(2)); 
	  				vendor.setEmail(rs.getString(4));
	  				vendor.setPassword(rs.getString(5));
					return vendor;
				
				}
				 
			 });
			}catch(EmptyResultDataAccessException erdae) {
				vendor1 = null; 
			}
			return vendor1;

	}

	@Override
	public List<Vendor> allUsers() {

		
		  		String sql = "SELECT * FROM vendor_information"; 
		  		
		  		return jdbcTemplate.query(sql, new RowMapper<Vendor>() {
					@Override
					public Vendor mapRow(ResultSet rs, int arg1) throws SQLException {
						Vendor vendor = new Vendor();
		  				vendor.setId(rs.getInt(1));
		  				vendor.setName(rs.getString(2)); 
		  				vendor.setEmail(rs.getString(4));
		  				vendor.setPassword(rs.getString(5));
					
						return vendor;
					}
		  			
		  		});
	}

	@Override
	public boolean deleteVendor(int id ) {
	
		boolean status = false;

		
		String sql="DELETE  FROM vendor_information WHERE vendor_id = ? ";
		
			int rows = jdbcTemplate.update(sql, id);

			if(rows != 0) {
				status = true;
			}
		
		return status;
		
	}

	@Override
	public boolean updateVendor(Vendor v) {
		
			String sql = "UPDATE vendor_information SET vendor_fname = ?, vendor_email = ?, vendor_password = ? WHERE Vendor_id = ?";

			int rows = jdbcTemplate.update(sql, v.getName(), v.getEmail(),v.getPassword(), v.getId());

		

		return rows != 0;
	}

	@Override
	public Vendor editVendor(int vid) {
		String sql = "SELECT * FROM vendor_information WHERE vendor_id = ?";

		Vendor v = new Vendor();

		try {

			v = jdbcTemplate.queryForObject(sql, new Object[] {vid}, new RowMapper<Vendor>() {

				@Override

				public Vendor mapRow(ResultSet rs, int numRow) throws SQLException {

					Vendor vendor = new Vendor();

					vendor.setId(rs.getInt(1));

					vendor.setName(rs.getString(2));

					vendor.setEmail(rs.getString(4));

					vendor.setPassword(rs.getString(5));

					return vendor;

				}

			});

		}catch(EmptyResultDataAccessException erdae) {

			erdae.printStackTrace();

		}

		return v;
	}

}
