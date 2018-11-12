package com.tadigital.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name = "customer_information")
@DynamicInsert(value= true)
public class Customer {
	
	@Id
	@Column(name="cust_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="cust_fname")
	private String firstName;
	
	@Column( name = "cust_lname")
	private String lastName;
	
	@Column( name = "cust_dob")
	private Calendar dob;
	
	@Column( name = "cust_gender")
	private String gender;
	
	@Column( name = "cust_email")
	private String email;
	
	@Column( name = "cust_contact")
	private String contact;
	
	@Column( name = "cust_password")
	private String password;
	
	
	public int getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Calendar getDob() {
		return dob;
	}
	public String getGender() {
		return gender;
	}
	public String getEmail() {
		return email;
	}
	public String getContact() {
		return contact;
	}
	public String getPassword() {
		return password;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setDob(Calendar dob) {
		this.dob = dob;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
