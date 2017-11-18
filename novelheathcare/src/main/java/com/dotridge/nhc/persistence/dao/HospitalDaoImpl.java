package com.dotridge.nhc.persistence.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.dotridge.nhc.persistence.entity.Hospital;

@Repository("hospitalDao")
public class HospitalDaoImpl implements HospitalDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public Hospital addHospital(Hospital hospital) {
		hibernateTemplate.save(hospital);
		return hospital;
	}

	public Hospital updateHospital(final Hospital hospital) {

		hibernateTemplate.update(hospital);
		return hospital;
	}

	public Hospital getHospitalById(final int id) {

		return hibernateTemplate.get(Hospital.class, id);
	}

	public boolean deleteHospital(final int id) {
		hibernateTemplate.delete(hibernateTemplate.get(Hospital.class, id));
		return (hibernateTemplate.get(Hospital.class, id) == null) ? true : false;
	}

	public List<Hospital> getHospitalByName(final String name) {

		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Hospital> getAllHospitals() {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		return (List<Hospital>) session.createCriteria(Hospital.class).list();
	}

	public List<Hospital> getAllHospitalsByPaging(int currentPage, int noOfRecordsForPage) {

		return null;
	}

	@Override
	public void updateHospitalStatus(final int hospId) {
		Hospital hospital = hibernateTemplate.get(Hospital.class, hospId);
		if (hospital.isStatus() == false) {
			hospital.setStatus(true);
			hibernateTemplate.update(hospital);
		} else {
			hospital.setStatus(false);
			hibernateTemplate.update(hospital);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Hospital> searchHospital(final String searchKey, final String searchValue) {
		List<Hospital> hospitalList = null;
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Hospital.class, "hospital");
		criteria.createAlias("hospital.address", "hospitalAddress");

		switch (searchKey.toLowerCase()) {

		case "hospitalname":
			criteria.add(Restrictions.like("hospitalName", searchValue + "%"));
			hospitalList = criteria.list();
			break;
		case "address1":
			criteria.add(Restrictions.like("hospitalAddress.address1", searchValue + "%"));
			hospitalList = criteria.list();
			break;

		case "email":
			criteria.add(Restrictions.like("email", searchValue + "%"));
			hospitalList = criteria.list();
			break;

		case "phone":

			criteria.add(Restrictions.like("phone", Long.parseLong(searchValue)));
			hospitalList = criteria.list();
			break;

		case "status":
			criteria.add(Restrictions.like("status", Boolean.parseBoolean(searchValue)));
			hospitalList = criteria.list();
			break;

		default:
			break;
		}
		return hospitalList;
	}

	@Override
	public boolean multiSelectHospitalDbOpeations(final List<Integer> paramList) {
		StringBuilder paramBuilder = new StringBuilder();
		for (int i = 0; i < paramList.size(); i++) {
			paramBuilder.append("?,");
		}
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Query query = session.createQuery("delete from Hospital where hospitalId in (:paramValues)");
		query.setParameter("paramValues", paramBuilder.deleteCharAt(paramBuilder.length() - 1).toString());
		int delteResult = query.executeUpdate();
		if (delteResult >= 1)
			return true;
		else
			return false;
	}

}
