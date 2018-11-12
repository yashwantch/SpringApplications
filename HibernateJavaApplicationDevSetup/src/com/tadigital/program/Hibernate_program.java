package com.tadigital.program;

import com.tadigital.hibernate.hibernateUtility;

public class Hibernate_program {
	public static void main(String...x) {
		
		hibernateUtility.getSessionFactory();
		
		hibernateUtility.closeSessionFactory();
	}

}
