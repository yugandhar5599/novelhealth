package com.dotridge.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dotridge.domain.Hospital;
import com.dotridge.util.SessionFactoryUtil;

@Repository
public class HospitalDaoImpl implements HospitalDao {

	/*
	 @Autowired 
	 public SessionFactory sessionFactory;*/
	 

	public Hospital addHospital(Hospital hostpital) {
		SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		Transaction trasaction = session.beginTransaction();
		session.save(hostpital);
		trasaction.commit();
		session.close();
		return hostpital;
	}
	
	public List<Hospital> getAllHospitalsByPaging(int currPage,int noOfRecPage) {
		SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Hospital");
		q.setFirstResult((currPage-1)*noOfRecPage);
		q.setMaxResults(noOfRecPage);
		List<Hospital> hospList = q.list();
		
		return hospList;
	}

	public boolean deleteHospital(int hospitalId) {
		boolean flag = false;
		SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		Transaction trasaction = session.beginTransaction();
		Hospital hospital = (Hospital) session.get(Hospital.class, hospitalId);
		session.delete(hospital);
		trasaction.commit();
		hospital = (Hospital) session.get(Hospital.class, hospitalId);
		if (hospital == null) {
			flag = true;
		}
		return flag;
	}

	public boolean activateHospital(int hospitalId) {
		SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		Hospital hospital = (Hospital) session.load(Hospital.class, hospitalId);
		hospital.setStatus(true);
		session.update(hospital);
		session.close();
		return hospital.isStatus();
	}

	public boolean inactivateHospital(int hospitalId) {
		SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		Hospital hospital = (Hospital) session.load(Hospital.class, hospitalId);
		hospital.setStatus(false);
		session.update(hospital);
		session.close();
		return hospital.isStatus();
	}

	public List<Hospital> getAllHospital() {
		SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Hospital");
		List<Hospital> listOfHospitals = query.list();

		session.close();
		System.out.println("list of hospitals are" + listOfHospitals.size());
		return listOfHospitals;
	}

	public List<Hospital> searchHospital(String hospitalName, String address1, String email, long phone,
			boolean status) {
		// TODO Auto-generated method stub
		return null;
	}

	public Hospital getHospitalById(int hospitalId) {
		SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		// Transaction transaction = session.beginTransaction();
		Hospital hospital = (Hospital) session.get(Hospital.class, hospitalId);
		session.close();
		System.out.println(hospital.toString());
		return hospital;
	}

	public Hospital updateHospital(Hospital hospital) {
		System.out.println("in hospital dao impl:\t" + hospital.toString());
		SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		Transaction trasaction = session.beginTransaction();
		// session.saveOrUpdate(hospital);
		session.merge(hospital);
		trasaction.commit();
		session.close();
		return hospital;
	}

	public List<Hospital> getHospitalByName(String hospitalName) {
		SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(Hospital.class);

		/*
		 * Hospital hospital=new Hospital();
		 * hospital.setHospitalName(hospitalName);
		 * criteria.add(Example.create(hospital));
		 */

		// criteria.setProjection(Projections.property(hospitalName));

		criteria.add(Restrictions.like("hospitalName", hospitalName));

		List<Hospital> listOfHospitals = criteria.list();
		session.close();
		return listOfHospitals;
	}

	public List<Hospital> getHospitalByEmail(String email) {
		SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(Hospital.class);

		/*
		 * Hospital hospital=new Hospital();
		 * hospital.setHospitalName(hospitalName);
		 * criteria.add(Example.create(hospital));
		 */

		// criteria.setProjection(Projections.property(hospitalName));

		criteria.add(Restrictions.like("email", email));

		List<Hospital> listOfHospitals = criteria.list();
		session.close();
		return listOfHospitals;
	}

	public List<Hospital> searchHospitalByName(String hospitalName) {
		System.out.println("HospitalDaoImpl:searchHospitalByName()");
		SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		//String hqlQuery="from Hospital";
		//String hqlQuery="from Hospital h where h.hospitalName like=hName";
		String hqlQuery="from Hospital h where h.hospitalName like ?";
		Query query = session.createQuery(hqlQuery);
		query.setParameter(0, "%"+hospitalName+"%");
		List<Hospital> hosptialList = query.list();
		System.out.println("size---> "+hosptialList.size());
		return hosptialList;
	}

	public List<Hospital> searchHospitalByEmail(String email) {
		System.out.println("HospitalDaoImpl:searchHospitalByEmail()");
		SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		String hqlQuery="from Hospital h where h.email like ?";
		Query query = session.createQuery(hqlQuery);
		query.setParameter(0, "%"+email+"%");
		List<Hospital> hosptialList = query.list();
		System.out.println("size---> "+hosptialList.size());
		return hosptialList;
	}

	public List<Hospital> searchHospitalByAddress1(String address1) {
		System.out.println("HospitalDaoImpl:searchHospitalByAddress1()");
		SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		String hqlQuery="from Hospital h where h.address1 like ?";
		Query query = session.createQuery(hqlQuery);
		query.setParameter(0, "%"+address1+"%");
		List<Hospital> hosptialList = query.list();
		System.out.println("size---> "+hosptialList.size());
		return hosptialList;
	}

	public List<Hospital> searchHospitalByPhone(long phone) {
		System.out.println("HospitalDaoImpl:searchHospitalByPhone()");
		SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		String hqlQuery="from Hospital h where h.phone like:hphone";
		Query query = session.createQuery(hqlQuery);
		query.setParameter("hphone", phone);
		List<Hospital> hosptialList = query.list();
		System.out.println("size---> "+hosptialList.size());
		return hosptialList;
	}

	public List<Hospital> searchHospitalByStatus(String status) {
		System.out.println("HospitalDaoImpl:searchHospitalByStatus()");
		SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		String hqlQuery="from Hospital h where h.status like ?";
		Query query = session.createQuery(hqlQuery);
		query.setParameter(0, "%"+status+"%");
		List<Hospital> hosptialList = query.list();
		System.out.println("size---> "+hosptialList.size());
		return hosptialList;
	}

	public Hospital getHospitalNames(String hospitalName) {
		SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		
		String hql="from Hospital hosp where hosp.hospitalName=:hospName";
		Query query = session.createQuery(hql);
		query.setParameter("hospName", hospitalName);
		Hospital hospital =(Hospital)query.uniqueResult();
		System.out.println("HospitalName:"+hospital);
		return hospital;
	}
}
