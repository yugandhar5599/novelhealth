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

import com.siri.esmartHealthCare.domain.PatientType;

/**
 * @author VENU
 *
 */
@Repository
public class PatientTypeDaoImpl implements PatientTypeDaoI {
	@Autowired
	private SessionFactory sf;

	/* (non-Javadoc)
	 * @see com.siri.espc.dao.PatientTypeDaoI#addPatientType(com.siri.espc.domain.PatientType)
	 */
	public PatientType addPatientType(PatientType ptype) {
		Session hsession=sf.openSession();
		hsession.save(ptype);
		return null;
	}

	/* (non-Javadoc)
	 * @see com.siri.espc.dao.PatientTypeDaoI#updatePatientType(com.siri.espc.domain.PatientType)
	 */
	public PatientType updatePatientType(PatientType ptype) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.siri.espc.dao.PatientTypeDaoI#deletePatientType(com.siri.espc.domain.PatientType)
	 */
	public Boolean deletePatientType(PatientType ptype) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.siri.espc.dao.PatientTypeDaoI#getPatientTypeByName(java.lang.String)
	 */
	public PatientType getPatientTypeByName(String name) {
		Session hsession=sf.openSession();
		Criteria criteria=hsession.createCriteria(PatientType.class).add(Restrictions.eq("type", name));
		PatientType ptype=(PatientType) criteria.uniqueResult();
		hsession.close();
		return ptype;
	}

	/* (non-Javadoc)
	 * @see com.siri.espc.dao.PatientTypeDaoI#getPatientTypeById(int)
	 */
	public PatientType getPatientTypeById(int id) {
		Session hsession=sf.openSession();
		PatientType ptype=(PatientType) hsession.get(PatientType.class, id);
		return ptype;
	}

	/* (non-Javadoc)
	 * @see com.siri.espc.dao.PatientTypeDaoI#getAllPatientType()
	 */
	public List<PatientType> getAllPatientType() {
	Session hsession=sf.openSession();
	Criteria criteria=hsession.createCriteria(PatientType.class);
	List<PatientType> ptypelist=criteria.list();
	
		return ptypelist;
	}

	/* (non-Javadoc)
	 * @see com.siri.espc.dao.PatientTypeDaoI#searchPatientType(java.lang.String, int)
	 */
	public List<PatientType> searchPatientType(String tyname, int id) {
		Session hsession=sf.openSession();
		Query query=hsession.createQuery("from PatientType where ptypeId=? or type=? ");
		query.setParameter(0, id);
		query.setParameter(1, tyname);
		List<PatientType> ptypeList=query.list();
		
		return ptypeList;
	}

}
