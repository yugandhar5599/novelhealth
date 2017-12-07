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

import com.siri.esmartHealthCare.domain.Medicines;
import com.siri.esmartHealthCare.domain.RequiredMedicines;

/**
 * @author VENU
 *
 */
@Repository
public class RequiredMedicinesDaoImpl implements RequiredMedicinesDao {

	@Autowired
	private SessionFactory sf;
	/* (non-Javadoc)
	 * @see com.siri.esmartHealthCare.dao.RequiredMedicinesDao#addRequiredMedicines(com.siri.esmartHealthCare.domain.RequiredMedicines)
	 */
	@Override
	public RequiredMedicines addRequiredMedicines(
			RequiredMedicines requiredMedicines) {
		Session session = sf.openSession();
		session.save(requiredMedicines);
		return requiredMedicines;

	}

	/* (non-Javadoc)
	 * @see com.siri.esmartHealthCare.dao.RequiredMedicinesDao#updateRequiredMedicines(com.siri.esmartHealthCare.domain.RequiredMedicines)
	 */
	@Override
	public RequiredMedicines updateRequiredMedicines(
			RequiredMedicines requiredMedicines) {
		Session session = sf.openSession();
		session.update(requiredMedicines);
		return requiredMedicines;
	}

	/* (non-Javadoc)
	 * @see com.siri.esmartHealthCare.dao.RequiredMedicinesDao#deleteRequiredMedicines(com.siri.esmartHealthCare.domain.RequiredMedicines)
	 */
	@Override
	public Boolean deleteRequiredMedicines(RequiredMedicines requiredMedicines) {
		Session session = sf.openSession();
		session.delete(requiredMedicines);
		return null;
	}

	/* (non-Javadoc)
	 * @see com.siri.esmartHealthCare.dao.RequiredMedicinesDao#getRequiredMedicinesByName(java.lang.String)
	 */
	@Override
	public RequiredMedicines getRequiredMedicinesByName(String medicinesName) {
		Session hsession = sf.openSession();
		Criteria criteria = hsession.createCriteria(RequiredMedicines.class).add(Restrictions.eq("medicinesName", medicinesName));
		RequiredMedicines medicines = (RequiredMedicines) criteria.uniqueResult();
		return medicines;
	}

	/* (non-Javadoc)
	 * @see com.siri.esmartHealthCare.dao.RequiredMedicinesDao#getRequiredMedicinesByDate(java.lang.String)
	 */
	@Override
	public List<RequiredMedicines> getRequiredMedicinesByDate(
			String medicinesName) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.siri.esmartHealthCare.dao.RequiredMedicinesDao#getRequiredMedicinesById(int)
	 */
	@Override
	public RequiredMedicines getRequiredMedicinesById(int medicinesId) {
		Session hsession = sf.openSession();
		RequiredMedicines medicines = (RequiredMedicines) hsession.get(RequiredMedicines.class, medicinesId);
		hsession.close();
		return medicines;
	}

	/* (non-Javadoc)
	 * @see com.siri.esmartHealthCare.dao.RequiredMedicinesDao#getAllRequiredMedicines()
	 */
	@Override
	public List<RequiredMedicines> getAllRequiredMedicines() {
		Session hsession = sf.openSession();
		Criteria criteria = hsession.createCriteria(RequiredMedicines.class);
		List<RequiredMedicines> medicineslist = criteria.list();
		return medicineslist;
	}

	/* (non-Javadoc)
	 * @see com.siri.esmartHealthCare.dao.RequiredMedicinesDao#searchAllRequiredMedicines(int, java.lang.String)
	 */
	@Override
	public List<RequiredMedicines> searchAllRequiredMedicines(int medicinesId,
			String medicinesName) {
		Session hsession=sf.openSession();
		Query query=hsession.createQuery("from RequiredMedicines where medicinesId=? or medicinesName=? ");
		query.setParameter(0, medicinesId);
		query.setParameter(1, medicinesName);
		List<RequiredMedicines> medicineslist=query.list();
		return medicineslist;
	}

}
