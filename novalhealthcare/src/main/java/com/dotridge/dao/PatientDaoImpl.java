package com.dotridge.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.dotridge.domain.Hospital;
import com.dotridge.domain.Patient;
import com.dotridge.domain.UserProfile;
import com.dotridge.util.SessionFactoryUtil;

@Repository
public class PatientDaoImpl implements PatientDao {

	public Patient addPatient(Patient patient) {
		SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		Transaction trasaction = session.beginTransaction();
		session.save(patient);
		trasaction.commit();
		session.close();
		return patient;
	}

	public Patient updatePatient(Patient patient) {
		System.out.println("in hospital dao impl:\t" + patient.toString());
		SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		Transaction trasaction = session.beginTransaction();
		// session.saveOrUpdate(hospital);
		session.merge(patient);
		trasaction.commit();
		session.close();
		return patient;
	}

	public boolean deletePatient(int pId) {
		boolean flag = false;
		SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		Transaction trasaction = session.beginTransaction();
		Patient patient = (Patient) session.get(Patient.class, pId);
		session.delete(patient);
		trasaction.commit();
		patient = (Patient) session.get(Patient.class, pId);
		if (patient == null) {
			flag = true;
		}
		return flag;
	}

	public List<Patient> getAllPatients() {
		SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		System.out.println("enter into patient dao");
		Query query = session.createQuery("from Patient");

		List<Patient> listofpatients = query.list();

		session.close();
		System.out.println("list of patients are" + listofpatients.size());
		return listofpatients;
	}

	public List<Patient> getAllPatientsByPaging(int currPage, int noOfRecPage) {
		// TODO Auto-generated method stub
		return null;
	}

	public Patient getPatientById(int pId) {
		SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		// Transaction transaction = session.beginTransaction();
		Patient patient = (Patient) session.get(Patient.class, pId);
		session.close();
		System.out.println(patient.toString());
		return patient;
	}

}
