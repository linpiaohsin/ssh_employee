package com.org.employee.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	private static Session session;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		// TODO Auto-generated method stub
		this.sessionFactory = sessionFactory;
	}
	
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	

	public static Session getSession() {
		session = sessionFactory.openSession();
		return session;
	}
	

	public static void closeSession(Session session) {
		
			session.close();
		
	}
}
