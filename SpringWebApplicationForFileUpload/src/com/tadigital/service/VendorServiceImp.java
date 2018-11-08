package com.tadigital.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.Part;

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
		
		vendor.setProfilepicture(processUpload(vendor.getPart()));
		
		return vendordao.register(vendor);
	}
	
	private String processUpload(Part part) {
		String contentDisp = part.getHeader("content-disposition");
	    String[] items = contentDisp.split(";");
	    String fileName = "";
	    for (String s : items) {
	        if (s.trim().startsWith("filename")) {
	            fileName = s.substring(s.indexOf("=") + 2, s.length()-1);
	        }
	    }
	    
	    FileOutputStream fos = null;
	    InputStream is = null;
	   
	    try {
	    	File file = new File("D:\\" + fileName);
	        fos = new FileOutputStream(file);
	        is = part.getInputStream();
	
	        int read = 0;
	        final byte[] bytes = new byte[1024];
	
	        while((read = is.read(bytes)) != -1) {
	            fos.write(bytes, 0, read);
	        }
	        
	    } catch (IOException ioe) {
	        ioe.printStackTrace();
	    } finally {
	    	try {
	    		if (fos != null) {
		            fos.close();
		        }
		        if (is != null) {
		        	is.close();
		        }
			} catch (IOException ioe) {
		        ioe.printStackTrace();
		    }
	    }
	    
	    return fileName;
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
