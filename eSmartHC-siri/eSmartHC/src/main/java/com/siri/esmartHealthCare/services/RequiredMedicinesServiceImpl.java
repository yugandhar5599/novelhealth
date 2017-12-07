/**
 * 
 */
package com.siri.esmartHealthCare.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siri.esmartHealthCare.beans.MedicinesBean;
import com.siri.esmartHealthCare.beans.RequiredMedicinesBean;
import com.siri.esmartHealthCare.dao.RequiredMedicinesDao;
import com.siri.esmartHealthCare.domain.Medicines;
import com.siri.esmartHealthCare.domain.RequiredMedicines;

/**
 * @author VENU
 *
 */
@Service
public class RequiredMedicinesServiceImpl implements RequiredMedicinesService {
	@Autowired
	RequiredMedicinesDao rmdao;

	/* (non-Javadoc)
	 * @see com.siri.esmartHealthCare.services.RequiredMedicinesService#addRequiredMedicines(com.siri.esmartHealthCare.beans.RequiredMedicinesBean)
	 */
	@Override
	public RequiredMedicinesBean addRequiredMedicines(
			RequiredMedicinesBean reqmedicinesBean) {
		RequiredMedicines medicines=mapBeanToDomain(reqmedicinesBean) ;
		RequiredMedicines medicine=rmdao.addRequiredMedicines(medicines);
		return null;
	}

	private RequiredMedicines mapBeanToDomain(
			RequiredMedicinesBean reqmedicinesBean) {
		RequiredMedicines rm=new RequiredMedicines();
		rm.setMedicinesId(reqmedicinesBean.getMedicinesId());
		rm.setCategoryName(reqmedicinesBean.getCategoryName());
		rm.setManifactureCompany(reqmedicinesBean.getManifactureCompany());
		rm.setMedicinesName(reqmedicinesBean.getMedicinesName());
		return rm;
	}

	/* (non-Javadoc)
	 * @see com.siri.esmartHealthCare.services.RequiredMedicinesService#updateRequiredMedicines(com.siri.esmartHealthCare.beans.RequiredMedicinesBean)
	 */
	@Override
	public RequiredMedicinesBean updateRequiredMedicines(
			RequiredMedicinesBean reqmedicinesBean) {
		RequiredMedicines medicines=mapBeanToDomain(reqmedicinesBean);
		RequiredMedicines medicines1=rmdao.updateRequiredMedicines(medicines);
		RequiredMedicinesBean mbean=mapDomainToBean(medicines1);
		return mbean;
	}

	private RequiredMedicinesBean mapDomainToBean(RequiredMedicines medicines1) {
		RequiredMedicinesBean rmbean=new RequiredMedicinesBean();
		rmbean.setCategoryName(medicines1.getCategoryName());
		rmbean.setManifactureCompany(medicines1.getManifactureCompany());
		rmbean.setMedicinesId(medicines1.getMedicinesId());
		rmbean.setMedicinesName(medicines1.getMedicinesName());
		return rmbean;
	}

	/* (non-Javadoc)
	 * @see com.siri.esmartHealthCare.services.RequiredMedicinesService#deleteRequiredMedicines(com.siri.esmartHealthCare.beans.RequiredMedicinesBean)
	 */
	@Override
	public Boolean deleteRequiredMedicines(
			RequiredMedicinesBean reqmedicinesBean) {
		RequiredMedicines rmedicines=mapBeanToDomain(reqmedicinesBean);
		rmdao.deleteRequiredMedicines(rmedicines);
		return null;
	}

	/* (non-Javadoc)
	 * @see com.siri.esmartHealthCare.services.RequiredMedicinesService#getRequiredMedicinesByName(java.lang.String)
	 */
	@Override
	public RequiredMedicinesBean getRequiredMedicinesByName(String medicinesName) {
		RequiredMedicines medicines=rmdao.getRequiredMedicinesByName(medicinesName);
		RequiredMedicinesBean mdbean=mapDomainToBean(medicines);
		return mdbean;
	}

	/* (non-Javadoc)
	 * @see com.siri.esmartHealthCare.services.RequiredMedicinesService#getRequiredMedicinesByDate(java.lang.String)
	 */
	@Override
	public List<RequiredMedicinesBean> getRequiredMedicinesByDate(
			String medicinesName) {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.siri.esmartHealthCare.services.RequiredMedicinesService#getRequiredMedicinesById(int)
	 */
	@Override
	public RequiredMedicinesBean getRequiredMedicinesById(int medicinesId) {
		RequiredMedicines medicines=rmdao.getRequiredMedicinesById(medicinesId);
		RequiredMedicinesBean mdbean=mapDomainToBean(medicines);
			return mdbean;
	}

	/* (non-Javadoc)
	 * @see com.siri.esmartHealthCare.services.RequiredMedicinesService#getAllRequiredMedicines()
	 */
	@Override
	public List<RequiredMedicinesBean> getAllRequiredMedicines() {
		List<RequiredMedicines> medlist=rmdao.getAllRequiredMedicines();
		List<RequiredMedicinesBean> medBeanList=new ArrayList<RequiredMedicinesBean>();
		for(RequiredMedicines medicines:medlist){
			RequiredMedicinesBean medBean=mapDomainToBean(medicines);
			medBeanList.add(medBean);
		}
		return medBeanList;
	}

	/* (non-Javadoc)
	 * @see com.siri.esmartHealthCare.services.RequiredMedicinesService#searchAllRequiredMedicines(int, java.lang.String)
	 */
	@Override
	public List<RequiredMedicinesBean> searchAllRequiredMedicines(
			int medicinesId, String medicinesName) {
		List<RequiredMedicines> mlist=rmdao.searchAllRequiredMedicines(medicinesId, medicinesName);
		List<RequiredMedicinesBean> mbeanlist=new ArrayList<RequiredMedicinesBean>();
		for(RequiredMedicines medicines:mlist){
			RequiredMedicinesBean mbean=mapDomainToBean(medicines);
			mbeanlist.add(mbean);	
		}
		return mbeanlist;

	}

}
