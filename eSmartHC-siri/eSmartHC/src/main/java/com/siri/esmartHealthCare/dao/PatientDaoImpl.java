package com.siri.esmartHealthCare.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.siri.esmartHealthCare.domain.Patient;
import com.siri.esmartHealthCare.domain.PatientType;

@Repository
public class PatientDaoImpl implements PatientDaoI {
	
	@Autowired
	private SessionFactory sf;

	public Patient addPatient(Patient patient) {
		System.out.println("i am in patient");
		Session session=sf.openSession();
		session.save(patient);
		return patient;
	}

	public Patient updatePatient(Patient patient) {
	Session hsession=sf.openSession();
	hsession.update(patient);
		return patient;
	}

	public Boolean deletePatient(Patient patient) {
	Session hsession=sf.openSession();
	Transaction txn=hsession.beginTransaction();
	hsession.delete(patient);
	txn.commit();
		return null;
	}

	public Patient getPatientByName(String pname) {
	Session hsession=sf.openSession();
	Criteria criteria=hsession.createCriteria(Patient.class).add(Restrictions.eq("pname", pname));
	Patient patient=(Patient) criteria.uniqueResult();
		return patient;
	}

	public Patient getPatientById(int pid) {
	Session hsession=sf.openSession();
	Patient patient=(Patient) hsession.get(Patient.class, pid);
		return patient;
	}

	public List<Patient> getAllPatients() {
	Session hsession=sf.openSession();
	Criteria criteria=hsession.createCriteria(Patient.class);
	List<Patient> plist=criteria.list();
		return plist;
	}

	public List<Patient> searchAllPatients(int id, String name) {
		Session hsession=sf.openSession();
		Query query=hsession.createQuery("from Patient where pid=? or pname=? ");
		query.setParameter(0, id);
		query.setParameter(1, name);
		List<Patient> patientList=query.list();
		
		return patientList;	}


}
