package com.utec.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	
	
	public HibernateUtil() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		try {
			sessionFactory = new Configuration().configure("com/utec/xml/hibernate.cfg.xml")
					.buildSessionFactory();
		}catch(Throwable ex) {
			System.err.println("Initial SessionFactory creation failed. " + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
