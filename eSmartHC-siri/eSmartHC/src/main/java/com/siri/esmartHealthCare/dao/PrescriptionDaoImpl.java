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

import com.siri.esmartHealthCare.domain.Patient;
import com.siri.esmartHealthCare.domain.Prescription;

/**
 * @author VENU
 *
 */
@Repository
public class PrescriptionDaoImpl implements PrescriptionDaoI {
	
	@Autowired
	private SessionFactory sf;

	/* (non-Javadoc)
	 * @see com.siri.espc.dao.PrescriptionDaoI#addPrescription(com.siri.espc.domains.Prescription)
	 */
	public Prescription addPrescription(Prescription prescription) {
		Session session=sf.openSession();
		session.save(prescription);
		session.close();
		return prescription;
	}

	/* (non-Javadoc)
	 * @see com.siri.espc.dao.PrescriptionDaoI#updatePrescription(com.siri.espc.domains.Prescription)
	 */
	public Prescription updatePrescription(Prescription prescription) {
		Session hsession=sf.openSession();
		hsession.update(prescription);
		hsession.close();
			return prescription;
	}

	/* (non-Javadoc)
	 * @see com.siri.espc.dao.PrescriptionDaoI#deletePrescription(com.siri.espc.domains.Prescription)
	 */
	public Boolean deletePrescription(Prescription prescription) {
		Session hsession=sf.openSession();
		Transaction txn=hsession.beginTransaction();
		hsession.delete(prescription);
		txn.commit();
			return null;	}

	/* (non-Javadoc)
	 * @see com.siri.espc.dao.PrescriptionDaoI#getPrescriptionByName(java.lang.String)
	 */
	public Prescription getPrescriptionByName(String prescription) {
		Session hsession=sf.openSession();
		Criteria criteria=hsession.createCriteria(Prescription.class).add(Restrictions.eq("prescription", prescription));
		Prescription prescription1=(Prescription) criteria.uniqueResult();
		hsession.close();
			return prescription1;	
			}

	/* (non-Javadoc)
	 * @see com.siri.espc.dao.PrescriptionDaoI#getPrescriptionById(int)
	 */
	public Prescription getPrescriptionById(int prescriptionId) {
		Session hsession=sf.openSession();
		Prescription prescription1=(Prescription) hsession.get(Prescription.class, prescriptionId);
		hsession.close();	
		return prescription1;
	}

	/* (non-Javadoc)
	 * @see com.siri.espc.dao.PrescriptionDaoI#getAllPrescriptions()
	 */
	public List<Prescription> getAllPrescriptions() {
			Session hsession=sf.openSession();
			Criteria criteria=hsession.createCriteria(Prescription.class);
			List<Prescription> prescriptionlist=criteria.list();
				return prescriptionlist;	
				}

	public List<Prescription> searchAllPrescriptions(int id, String name) {
		Session hsession=sf.openSession();
		Query query=hsession.createQuery("from Prescription where prescriptionId=? or prescription=?");
		query.setParameter(0, id);
		query.setParameter(1, name);
		List<Prescription> preslist=query.list();
		return preslist;
	}

}
