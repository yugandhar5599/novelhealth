/**
 * 
 */
package com.siri.esmartHealthCare.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.siri.esmartHealthCare.domain.Guardian;
import com.siri.esmartHealthCare.domain.Medicines;

/**
 * @author VENU
 *
 */
@Repository
public class MedicinesDaoImpl implements MedicinesDao {
	
	Logger logger = Logger.getLogger(MedicinesDaoImpl.class);
	@Autowired
	private SessionFactory sf;

	/* (non-Javadoc)
	 * @see com.siri.esmartHealthCare.dao.MedicinesDao#addMedicines(com.siri.esmartHealthCare.domain.Medicines)
	 */
	@Override
	public Medicines addMedicines(Medicines medicine) {
		Session session = sf.openSession();
		session.save(medicine);
		return medicine;
	}

	/* (non-Javadoc)
	 * @see com.siri.esmartHealthCare.dao.MedicinesDao#updateMedicines(com.siri.esmartHealthCare.domain.Medicines)
	 */
	@Override
	public Medicines updateMedicines(Medicines medicine) {
		Session session = sf.getCurrentSession();
		session.update(medicine);
		return medicine;
	}

	/* (non-Javadoc)
	 * @see com.siri.esmartHealthCare.dao.MedicinesDao#deleteMedicines(com.siri.esmartHealthCare.domain.Medicines)
	 */
	@Override
	public Boolean deleteMedicines(Medicines medicine) {
		Session session = sf.getCurrentSession();
		session.delete(medicine);
		return null;
	}

	/* (non-Javadoc)
	 * @see com.siri.esmartHealthCare.dao.MedicinesDao#getMedicinesByName(java.lang.String)
	 */
	@Override
	public Medicines getMedicinesByName(String medicineName) {
		Session hsession = sf.openSession();
		Criteria criteria = hsession.createCriteria(Medicines.class).add(Restrictions.eq("medicineName", medicineName));
		Medicines medicines = (Medicines) criteria.uniqueResult();
		return medicines;
	}

	/* (non-Javadoc)
	 * @see com.siri.esmartHealthCare.dao.MedicinesDao#getMedicinesById(int)
	 */
	@Override
	public Medicines getMedicinesById(int medicineId) {
		Session hsession = sf.openSession();
		Medicines medicines = (Medicines) hsession.get(Medicines.class, medicineId);
		hsession.close();
		return medicines;
	}

	/* (non-Javadoc)
	 * @see com.siri.esmartHealthCare.dao.MedicinesDao#getAllMedicines()
	 */
	@Override
	public List<Medicines> getAllMedicines() {
		Session hsession = sf.openSession();
		Criteria criteria = hsession.createCriteria(Medicines.class);
		List<Medicines> medicineslist = criteria.list();
		return medicineslist;
	}

	/* (non-Javadoc)
	 * @see com.siri.esmartHealthCare.dao.MedicinesDao#searchAllMedicines(int, java.lang.String)
	 */
	@Override
	public List<Medicines> searchAllMedicines(int medicineId,
			String medicineName) {
		Session hsession=sf.openSession();
		Query query=hsession.createQuery("from Medicines where medicineId=? or medicineName=? ");
		query.setParameter(0, medicineId);
		query.setParameter(1, medicineName);
		List<Medicines> medicineslist=query.list();
		return medicineslist;
	}

	@Override
	public List<Medicines> getMedicinesByDate(Date date) {
		
		Session hsession = sf.openSession();
		logger.info("date from ui search..."+date);	
		Query query=hsession.createQuery("from Medicines where expiredDate=?");
		query.setParameter(0, date);
		List<Medicines> medicinesList= query.list();
		for(Medicines md:medicinesList){
		System.out.println(md.getMedicineName());
		}
		/*Criteria criteria = hsession.createCriteria(Medicines.class).add(Restrictions.eq("expiredDate", medicineName));
		Medicines medicines = (Medicines) criteria.uniqueResult();*/
		return medicinesList;

	}

}
