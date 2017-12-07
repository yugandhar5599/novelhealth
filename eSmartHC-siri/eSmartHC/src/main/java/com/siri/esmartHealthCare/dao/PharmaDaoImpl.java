/**
 * 
 */
package com.siri.esmartHealthCare.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.siri.esmartHealthCare.domain.Doctor;
import com.siri.esmartHealthCare.domain.Pharma;

/**
 * @author VENU
 *
 */
@Repository
public class PharmaDaoImpl implements PharmaDao{

	@Autowired
	private SessionFactory sf;
	
	@Override
	public Pharma addPharma(Pharma pharma) {
		System.out.println("am in add pharma dao impl");
		Session ses = sf.openSession();
		ses.save(pharma);
		ses.close();
		return pharma;
	}

	@Override
	public Pharma updatePharma(Pharma pharma) {
		Session ses = sf.getCurrentSession();
		System.out.println("dao"+pharma.getPharmaId());
		ses.update(pharma);
		//ses.beginTransaction().commit();
		return pharma;
	}

	@Override
	public Boolean deletePharma(Pharma pharma) {
		Session ses = sf.getCurrentSession();
		ses.delete(pharma);
		//ses.beginTransaction().commit();
		return true;
	}

	@Override
	public Pharma getPharmaByName(String pharmaName) {
		Session hsession = sf.openSession();
		System.out.println("is session created::"+hsession.isOpen());
		Criteria criteria=hsession.createCriteria(Pharma.class).
				add(Restrictions.eq("pharmaName",pharmaName));
		System.out.println(criteria.list().size());
		Pharma pharma=(Pharma) criteria.uniqueResult();
		return pharma;
	}

	@Override
	public Pharma getPharmaById(int pharmaId) {
		Session ses = sf.openSession();
		Pharma pharma=(Pharma) ses.get(Pharma.class, pharmaId);
		return pharma;
	}

	@Override
	public List<Pharma> getAllPharmas() {
		Session ses=sf.openSession();
		Criteria ct=ses.createCriteria(Pharma.class);
		List<Pharma> pharma=ct.list();
		return pharma;
	}

	@Override
	public List<Pharma> searchAllPharmas(int pharmaId, String pharmaName) {
		Session hsession=sf.openSession();
		Query query=hsession.createQuery("from Pharma where pharmaId=? or pharmaName=? ");
		query.setParameter(0, pharmaId);
		query.setParameter(1, pharmaName);
		List<Pharma> pharmalist=query.list();
		
		return pharmalist;
	}

	@Override
	public Boolean deletePharma(int pharmaId) {
		Session session=sf.getCurrentSession();
		Query query=session.createQuery("from Pharma where pharmaId=?");
		query.setParameter(0, pharmaId);
		Pharma pharma=(Pharma) query.uniqueResult();
		session.delete(pharma);
		return null;
	}

}
