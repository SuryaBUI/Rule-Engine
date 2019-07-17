package com.conifer.health.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
 
public class HibernateUtil {
 
private static final SessionFactory sessionFactory;
	
	static{
		try{
			sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
			
			
		}catch (Throwable ex) {
			System.err.println("Session Factory could not be created." + ex);
			throw new ExceptionInInitializerError(ex);
		}	
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public static Session getSession() {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session= sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		return session;
	}
}