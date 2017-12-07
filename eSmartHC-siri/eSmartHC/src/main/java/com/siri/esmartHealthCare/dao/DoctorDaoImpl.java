/**
 * 
 */
package com.siri.esmartHealthCare.dao;

import java.util.List;

import javassist.tools.rmi.ObjectNotFoundException;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.siri.esmartHealthCare.domain.Doctor;


/**
 * @author VENU
 *
 */
@Repository
public class DoctorDaoImpl implements DoctorDaoI {
	
	@Autowired
	private SessionFactory sf;

	public Doctor addDoctor(Doctor doctor) {
		System.out.println("am in add doctor dao impl");
		Session ses = sf.openSession();
		ses.save(doctor);
		ses.close();
		return doctor;
		
	}
	public void updateDoctor(Doctor doctor) {
		Session ses = sf.getCurrentSession();
		System.out.println("dao"+doctor.getDocId());
		ses.update(doctor);
		//ses.beginTransaction().commit();
		
		//return doctor;
	}

	public Boolean deleteDoctor(Doctor doctor) {
		Session ses = sf.getCurrentSession();
		ses.delete(doctor);
		//ses.beginTransaction().commit();
		return true;
	}

	public Doctor getDoctorByName(String name) {
		Session hsession = sf.openSession();
		System.out.println("is session created::"+hsession.isOpen());
		Criteria criteria=hsession.createCriteria(Doctor.class).
				add(Restrictions.eq("name",name));
		System.out.println(criteria.list().size());
		Doctor doc=(Doctor) criteria.uniqueResult();
		return doc;
	}

	public Doctor getDoctorById(int docId) {
		Session ses = sf.openSession();
		Doctor doc=(Doctor) ses.get(Doctor.class, docId);
		return doc;
	}

	public List<Doctor> getAllDoctors() {
		Session ses=sf.openSession();
		Criteria ct=ses.createCriteria(Doctor.class);
		List<Doctor> doc=ct.list();
		return doc;
	}

	public List<Doctor> searchAllDoctors(int id, String name) {
		Session hsession=sf.openSession();
		Query query=hsession.createQuery("from Doctor where docId=? or name=? ");
		query.setParameter(0, id);
		query.setParameter(1, name);
		List<Doctor> dlist=query.list();
		
		return dlist;
	}
	@Override
	public String deleteDoctor(int docId) {
		String msg="";
		System.out.println("docdao called"+docId);
		
		Session session=sf.getCurrentSession();
		Query query=session.createQuery("from Doctor where docId=?");
		query.setParameter(0, docId);
		Doctor doc=(Doctor) query.uniqueResult();
		session.delete(doc);
		try{
		Doctor doci=(Doctor) session.get(Doctor.class, docId);
		//msg="failure";
		doci.getDocId();
		}
		catch(NullPointerException e){
			msg="Success";
			System.out.println("==========================="+msg);
		}
		return msg;
	}

	
}
