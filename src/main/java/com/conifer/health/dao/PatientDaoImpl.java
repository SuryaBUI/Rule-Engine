package com.conifer.health.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.conifer.health.main.HibernateUtil;
import com.conifer.health.entity.Patient;


@Repository("patientDao")
public class PatientDaoImpl implements PatientDao{
	final static Logger logger = Logger
			.getLogger(PatientDaoImpl.class);
	public ArrayList<Patient> findAllPatients()
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unused")
		Transaction tx = session.beginTransaction();
		@SuppressWarnings("unchecked")	
		ArrayList<Patient> patientList = (ArrayList<Patient>)session.createQuery("from Patient").list();
		for(Patient patient : patientList){
			logger.info("List of Patient::"+patient.toString());
		}
		return patientList;
	}
}
