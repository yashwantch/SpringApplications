package com.tadigital.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tadigital.entity.Vendor;

@Repository
public class VendorDaoImp implements VendorDao {
		
	private static final  Logger LOGGER = Logger.getLogger("VendorDao excecution"); 

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate; 
	
	@Autowired
	 public VendorDaoImp(DataSource dataSource) {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	 }

	@Override
	public boolean register(Vendor vendor) {
		
		LOGGER.info("VendorDao : register  method : execution started");

		boolean status = false;
		
			String sql = "INSERT INTO vendor_information(vendor_fname, vendor_email, vendor_password) " + "VALUES(:name, :email, :password)";
			
			BeanPropertySqlParameterSource parameters = new BeanPropertySqlParameterSource(vendor);
			
			int rows = namedParameterJdbcTemplate.update(sql, parameters);
			if (rows != 0) {
				status = true;
			}
			
			LOGGER.info("VendorDao : register  method : execution ended");

		return status;
	}

	@Override
	public Vendor login(Vendor vendor) {
			
			LOGGER.info("VendorDao : login  method : execution started");

			String sql = "SELECT * FROM vendor_information WHERE vendor_email = :email AND vendor_password = :password ";
			
			BeanPropertySqlParameterSource parameters = new BeanPropertySqlParameterSource(vendor);
			

			Vendor vendor1 ;
			try {
			 vendor1 =   namedParameterJdbcTemplate.queryForObject(sql, parameters,  new RowMapper<Vendor>() {

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
			
			LOGGER.info("VendorDao : login  method : execution ended");

			return vendor1;

	}

	@Override
	public List<Vendor> allUsers() {
		
		LOGGER.info("VendorDao : allUsers  method : execution started");
		
		  		String sql = "SELECT * FROM vendor_information"; 
		  		
		  		List<Vendor> list1 =  namedParameterJdbcTemplate.query(sql, new RowMapper<Vendor>() {
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
		  		
				LOGGER.info("VendorDao : allUsers  method : execution ended");
		  		
		  		return list1;
	}

	@Override
	public boolean deleteVendor(int id ) {
	
		boolean status = false;

		
		String sql="DELETE  FROM vendor_information WHERE vendor_id = :vid ";
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		

		parameters.addValue("vid", id);
		
			int rows = namedParameterJdbcTemplate.update(sql, parameters);

			if(rows != 0) {
				status = true;
			}
		
		return status;
		
	}

	@Override
	public boolean updateVendor(Vendor v) {
		
			LOGGER.info("VendorDao : updateVendor  method : execution started");
		
			String sql = "UPDATE vendor_information SET vendor_fname = :name, vendor_email = :email, vendor_password = :password WHERE Vendor_id = :id";
			
			BeanPropertySqlParameterSource parameters = new BeanPropertySqlParameterSource(v);

			int rows = namedParameterJdbcTemplate.update(sql, parameters);
			
			LOGGER.info("VendorDao : updateVendor  method : execution ended");
			
		return rows != 0;
	}

	@Override
	public Vendor editVendor(int vid) {
		
		LOGGER.info("VendorDao : editVendor  method : execution started");
		
		String sql = "SELECT * FROM vendor_information WHERE vendor_id = :id";
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("id", vid);
		

		Vendor v = new Vendor();

		try {
			
			v = namedParameterJdbcTemplate.queryForObject(sql, parameters, new RowMapper<Vendor>() {

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
			v = null; 
		}
		
		LOGGER.info("VendorDao : editVendor  method : execution ended");

		return v;
	}

}
