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
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tadigital.entity.Vendor;

@Repository
public class VendorDaoImp implements VendorDao {
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate; 
	
	@Autowired
	 public VendorDaoImp(DataSource dataSource) {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	 }

	@Override
	public boolean register(Vendor vendor) {
		boolean status = false;
		
			String sql = "INSERT INTO vendor_information(vendor_fname, vendor_email, vendor_password) " + "VALUES(:vname, :vemail, :vpassword)";
			
			MapSqlParameterSource parameters = new MapSqlParameterSource();
			parameters.addValue("vname", vendor.getName());
			parameters.addValue("vemail", vendor.getEmail());
			parameters.addValue("vpassword", vendor.getPassword());

			
			int rows = namedParameterJdbcTemplate.update(sql, parameters);
			if (rows != 0) {
				status = true;
			}
		return status;
	}

	@Override
	public Vendor login(Vendor vendor) {
			
			String sql = "SELECT * FROM vendor_information WHERE vendor_email = :vemail AND vendor_password = :vpassword ";
			
			MapSqlParameterSource parameters = new MapSqlParameterSource();
			
			
			parameters.addValue("vemail", vendor.getEmail());
			parameters.addValue("vpassword", vendor.getPassword());
			

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
			return vendor1;

	}

	@Override
	public List<Vendor> allUsers() {

		
		  		String sql = "SELECT * FROM vendor_information"; 
		  		
		  		return namedParameterJdbcTemplate.query(sql, new RowMapper<Vendor>() {
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
		
			String sql = "UPDATE vendor_information SET vendor_fname = :vname, vendor_email = :vemail, vendor_password = :vpassword WHERE Vendor_id = :vid";
			
			MapSqlParameterSource parameters = new MapSqlParameterSource();
			parameters.addValue("vid", v.getId());
			parameters.addValue("vname", v.getName());
			parameters.addValue("vemail", v.getEmail());
			parameters.addValue("vpassword", v.getPassword());

			int rows = namedParameterJdbcTemplate.update(sql, parameters);
			
		return rows != 0;
	}

	@Override
	public Vendor editVendor(int vid) {
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

			erdae.printStackTrace();

		}

		return v;
	}

}
