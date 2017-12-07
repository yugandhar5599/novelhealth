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

/**
 * @author VENU
 *
 */
@Repository
public class GuardianDaoImpl implements GuardianDaoI {

	@Autowired
	private SessionFactory sf;

	public Guardian addGuardian(Guardian guardian) {
		Session session = sf.openSession();
		session.save(guardian);
		return guardian;
	}

	public Guardian updateGuardian(Guardian guardian) {
		Session hsession = sf.openSession();
		//Transaction txn = hsession.beginTransaction();
		hsession.update(guardian);
		//txn.commit();
		return guardian;
	}

	public Boolean deleteGuardian(Guardian guardian) {
		Session hsession = sf.openSession();
		hsession.delete(guardian);
		return null;
	}

	public Guardian getGuardianByName(String gname) {
		Session hsession = sf.openSession();
		Criteria criteria = hsession.createCriteria(Guardian.class).add(
				Restrictions.eq("name", gname));
		Guardian guardian = (Guardian) criteria.uniqueResult();
		return guardian;
	}

	public Guardian getGuardianById(int gid) {
		Session hsession = sf.openSession();
		Guardian guardian = (Guardian) hsession.get(Guardian.class, gid);
		hsession.close();
		return guardian;
	}

	public List<Guardian> getAllGuardians() {
		Session hsession = sf.openSession();
		Criteria criteria = hsession.createCriteria(Guardian.class);
		List<Guardian> gurdlist = criteria.list();
		return gurdlist;
	}

	public List<Guardian> searchAllGuardian(int id, String name) {
		Session hsession=sf.openSession();
		Query query=hsession.createQuery("from Guardian where gid=? or name=? ");
		query.setParameter(0, id);
		query.setParameter(1, name);
		List<Guardian> gdlist=query.list();
		return gdlist;
	}

}
