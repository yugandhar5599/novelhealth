/**
 * 
 */
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

import com.siri.esmartHealthCare.domain.Guardian;
import com.siri.esmartHealthCare.domain.Lab;

/**
 * @author VENU
 *
 */
@Repository
public class LabDaoImpl implements LabDao{
	
	@Autowired
	private SessionFactory sf;


	@Override
	public Lab addLab(Lab lab) {
		Session session = sf.openSession();
		session.save(lab);
		return lab;
	}

	@Override
	public Lab updateLab(Lab lab) {
		Session hsession = sf.getCurrentSession();
		//Transaction txn = hsession.beginTransaction();
		hsession.update(lab);
		//txn.commit();
		return lab;
	}

	@Override
	public Boolean deleteLab(Lab lab) {
		Session hsession = sf.getCurrentSession();
		hsession.delete(lab);
		return true;
	}

	@Override
	public Lab getLabByName(String labName) {
		Session hsession = sf.openSession();
		Criteria criteria = hsession.createCriteria(Lab.class).add(
				Restrictions.eq("labName", labName));
		Lab lab = (Lab) criteria.uniqueResult();
		return lab;
	}

	@Override
	public Lab getLabById(int labId) {
		Session hsession = sf.openSession();
		Lab lab = (Lab) hsession.get(Lab.class, labId);
		hsession.close();
		return lab;
	}

	@Override
	public List<Lab> getAllLabs() {
		Session hsession = sf.openSession();
		Criteria criteria = hsession.createCriteria(Lab.class);
		List<Lab> lablist = criteria.list();
		return lablist;
	}

	@Override
	public List<Lab> searchAllLab(int labId, String labName) {
		Session hsession=sf.openSession();
		Query query=hsession.createQuery("from Lab where labId=? or labName=? ");
		query.setParameter(0, labId);
		query.setParameter(1, labName);
		List<Lab> lablist=query.list();
		return lablist;
	}

	@Override
	public Boolean deleteLab(int labId) {
		Session session=sf.getCurrentSession();
		Query query=session.createQuery("from Lab where labId=?");
		query.setParameter(0, labId);
		Lab lab=(Lab) query.uniqueResult();
		session.delete(lab);
		return null;
	}

}
