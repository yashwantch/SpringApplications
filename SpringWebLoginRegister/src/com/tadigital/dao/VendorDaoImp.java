package com.tadigital.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.tadigital.entity.Vendor;

@Repository
public class VendorDaoImp implements VendorDao {

	@Override
	public boolean register(Vendor vendor) {
		boolean status = false;
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommercedb", "root", "");
			stmt = con.createStatement();

			String sql = "INSERT INTO vendor_information(vendor_fname, vendor_email, vendor_password) " + "VALUES('"
					+ vendor.getName() + "','" + vendor.getEmail() + "','" + vendor.getPassword() + "')";

			int rows = stmt.executeUpdate(sql);
			if (rows != 0) {
				status = true;
			}
			stmt.close();
			con.close();
		} catch (SQLException | ClassNotFoundException sqle) {
			sqle.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return status;
	}

	@Override
	public boolean login(Vendor vendor) {
		return false;
	}

}