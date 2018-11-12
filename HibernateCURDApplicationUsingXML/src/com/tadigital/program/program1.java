package com.tadigital.program;



import java.util.Iterator;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.tadigital.entity.Contact;
import com.tadigital.entity.Customer;
import com.tadigital.hibernate.hibernateUtility;

public class program1 {
	@SuppressWarnings("unchecked")
	public static void main(String...x) {
		
	 SessionFactory sessionFactory  =	hibernateUtility.getSessionFactory();
	 
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Customer cust2 = new Customer();
		cust2.setFirstName("ram9");
		cust2.setLastName("murty1");
		cust2.setGender("Male");
		cust2.setEmail("rammurty9@gmail.com");
		cust2.setPassword("123");
		
		Customer cust1 = new Customer();
		cust1.setFirstName("sumanth9");
		cust1.setLastName("bhargav1");
		cust1.setGender("Male");
		cust1.setEmail("sumanth9@gmail.com");
		cust1.setPassword("1234");
		
		Contact contact = new Contact();
		contact.setFirstName("ram9");
		contact.setLastName("murty1");
		contact.setEmail("rammurty9@gmail.com");
		contact.setSubject("problem1");
		contact.setMessage("hello sir problem1 description");
		
		Contact contact1 = new Contact();
		contact1.setFirstName("ram9");
		contact1.setLastName("murty1");
		contact1.setEmail("rammurty9@gmail.com");
		contact1.setSubject("problem2");
		contact1.setMessage("hello sir problem2 description");
		
		session.save(cust2);
		session.save(cust1);
		session.save(contact);
		session.save(contact1);
		
		String hql = "FROM Customer";	
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery(hql);
		
		List<Customer> list = query.list();
		for(Customer c : list) {

			System.out.println("Name" + c.getFirstName());

			System.out.println();
			System.out.println("first");

		}

		hql = "SELECT cobj.firstName FROM Customer cobj WHERE cobj.lastName = 'kumar'";

		query = session.createQuery(hql);

		@SuppressWarnings("deprecation")
		Iterator<Object> iterator = query.iterate();

		while(iterator.hasNext()) {

			Object object = iterator.next();

			System.out.println("Name: " + (String)object);

			System.out.println();
			System.out.println("second");

		}

		

		Customer c1 = session.get(Customer.class, 23);

		if(c1 != null) {

			System.out.println("Name: " + c1.getFirstName() + c1.getLastName());

			System.out.println();
			System.out.println("third");

		}

		else {

			System.out.println("No record Found");

			System.out.println();

		}

		

		//Update

		Customer cust = session.get(Customer.class, 27);

		if(cust != null) {
			System.out.println(cust.getFirstName());
			cust.setFirstName("Testing");

			session.update(cust);
			
			 cust = session.get(Customer.class, 29);
			 System.out.println(cust.getFirstName());

			System.out.println("Record Updated");
			System.out.println("forth");

		}

		else {

			System.out.println("Record upation not successful");

		}

		

		//Delete

		Customer customer2 = session.get(Customer.class, 31);

		if(customer2 != null) {
			System.out.println(customer2.getFirstName());

			session.delete(customer2);

			System.out.println("Record Deleted");
			System.out.println("fifth");

		}

		else {

			System.out.println("Record deletion not successful");

		}
		
		transaction.commit();
		
		session.close();
		
		hibernateUtility.closeSessionFactory();
	}

}
