package com.dotridge.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.dotridge.domain.Admin;
import com.dotridge.domain.Nurse;
import com.dotridge.util.SessionFactoryUtil;
@Repository
public class NurseDaoImpl implements NurseDao{
	
	

	@Override
	public Nurse createNurse(Nurse nurseDomain) {
		SessionFactory sessionFactory = SessionFactoryUtil.getfactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(nurseDomain);
		session.getTransaction().commit();
		session.close();
		return nurseDomain;
	}

	@Override
	public Nurse updateNurse(int id) {
		SessionFactory sessionFactory = SessionFactoryUtil.getfactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Nurse nurseDomain=(Nurse)session.load(Nurse.class, id);
		session.update(nurseDomain);
		session.getTransaction().commit();
		session.close();
		return nurseDomain;	
	}

	@Override
	public Nurse getNurseById(int id) {
		SessionFactory sessionFactory = SessionFactoryUtil.getfactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Nurse nurseDomain=(Nurse)session.load(Nurse.class, id);
		session.getTransaction().commit();
		return nurseDomain;
	}

	@Override
	public List<Nurse> getNurseName(String firstName) {
		SessionFactory sessionFactory = SessionFactoryUtil.getfactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		String hql = "from nurse n where n.firstName like:FirstName";
		Query query = session.createQuery(hql);
		query.setParameter("FirstName", "%" + firstName + "%");
		List<Nurse> nurseDomains = query.list();
		session.close();
		return nurseDomains;
	}

	@Override
	public List<Nurse> getAllNurses() {
		SessionFactory sessionFactory = SessionFactoryUtil.getfactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		String hql = "from nurse";
		Query query = session.createQuery(hql);
		List<Nurse> nurseDomains = query.list();
		session.close();
		return nurseDomains;
	}

	@Override
	public boolean deleteNurse(int id) {
		SessionFactory sessionFactory = SessionFactoryUtil.getfactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Nurse nurseDomain=(Nurse)session.load(Nurse.class, id);
		session.delete(nurseDomain);
		session.close();
		if(nurseDomain == null)
		{
			return true;
		}
		return false;
	}

	@Override
	public List<Nurse> getAllAdminsByPagining(int currentPage,
			int numberOfRecords) {
		// TODO Auto-generated method stub
		return null;
	}

}
