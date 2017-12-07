/**
 * 
 */
package com.siri.esmartHealthCare.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siri.esmartHealthCare.beans.PatientTypeBean;
import com.siri.esmartHealthCare.dao.PatientTypeDaoI;
import com.siri.esmartHealthCare.domain.PatientType;

/**
 * @author VENU
 *
 */
@Service
public class PatientTypeServiceImpl implements PatientTypeServiceI {
	@Autowired
	private PatientTypeDaoI dao;

	/* (non-Javadoc)
	 * @see com.siri.espc.service.PatientTypeServiceI#addPatientType(com.siri.espc.bean.PatientTypeBean)
	 */
	public PatientTypeBean addPatientType(PatientTypeBean ptypeBean) {
		PatientType type=mapBeanToDomain(ptypeBean);
		dao.addPatientType(type);
		return null;
	}

	private PatientType mapBeanToDomain(PatientTypeBean ptypeBean) {
		PatientType type=new PatientType();
		type.setPtypeId(ptypeBean.getPtypeId());
		type.setType(ptypeBean.getType());
		return type;
	}

	/* (non-Javadoc)
	 * @see com.siri.espc.service.PatientTypeServiceI#updatePatientType(com.siri.espc.bean.PatientTypeBean)
	 */
	public PatientTypeBean updatePatientType(PatientTypeBean ptypeBean) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.siri.espc.service.PatientTypeServiceI#deletePatientType(com.siri.espc.bean.PatientTypeBean)
	 */
	public Boolean deletePatientType(PatientTypeBean ptypeBean) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.siri.espc.service.PatientTypeServiceI#getPatientTypeByName(java.lang.String)
	 */
	public PatientTypeBean getPatientTypeByName(String name) {
		
		PatientType ptype=dao.getPatientTypeByName(name);
		PatientTypeBean pbean=mapDomainToBean(ptype);
		
		return pbean;
	}

	/* (non-Javadoc)
	 * @see com.siri.espc.service.PatientTypeServiceI#getPatientTypeById(int)
	 */
	public PatientTypeBean getPatientTypeById(int id) {
		PatientType type=dao.getPatientTypeById(id);
		PatientTypeBean pbean=mapDomainToBean(type);
		return pbean;
	}

	/* (non-Javadoc)
	 * @see com.siri.espc.service.PatientTypeServiceI#getAllPatientTypes()
	 */
	public List<PatientTypeBean> getAllPatientTypes() {
		List<PatientType> ptypelist=dao.getAllPatientType();
		List<PatientTypeBean> pbeanlist=new ArrayList<PatientTypeBean>();
		for(PatientType ptype:ptypelist){
			PatientTypeBean pbean=mapDomainToBean(ptype);
			pbeanlist.add(pbean);
			
		}
		return pbeanlist;
	}

	/* (non-Javadoc)
	 * @see com.siri.espc.service.PatientTypeServiceI#searchPatientType(java.lang.String, int)
	 */
	public List<PatientTypeBean> searchPatientType(String tyname, int id) {
		List<PatientType> ptypelist=dao.searchPatientType(tyname, id);
		List<PatientTypeBean> ptypebeanList=new ArrayList<PatientTypeBean>();
		for(PatientType ptype:ptypelist){
			PatientTypeBean ptypebean=mapDomainToBean(ptype);
			ptypebeanList.add(ptypebean);
		}
		
		return ptypebeanList;
	}

	private PatientTypeBean mapDomainToBean(PatientType ptype) {
		PatientTypeBean ptypebean=new PatientTypeBean();
		ptypebean.setPtypeId(ptype.getPtypeId());
		ptypebean.setType(ptype.getType());
		return ptypebean;
	}

}
