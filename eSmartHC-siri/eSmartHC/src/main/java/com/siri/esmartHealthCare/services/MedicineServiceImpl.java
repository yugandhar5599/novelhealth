/**
 * 
 */
package com.siri.esmartHealthCare.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.siri.esmartHealthCare.beans.MedicinesBean;
import com.siri.esmartHealthCare.dao.MedicinesDao;
import com.siri.esmartHealthCare.domain.Medicines;

/**
 * @author VENU
 *
 */
@Service
public class MedicineServiceImpl implements MedicinesService {
	
	@Autowired
	private MedicinesDao mdao;

	/* (non-Javadoc)
	 * @see com.siri.esmartHealthCare.services.MedicinesService#addMedicines(com.siri.esmartHealthCare.beans.MedicinesBean)
	 */
	@Override
	public MedicinesBean addMedicines(MedicinesBean medicinesBean) {
		Medicines medicines=mapBeanToDomain(medicinesBean) ;
		Medicines medicine=mdao.addMedicines(medicines);
		return null;
	}

	private Medicines mapBeanToDomain(MedicinesBean medicinesBean) {
		Medicines medicines=new Medicines();
		medicines.setMedicineId(medicinesBean.getMedicineId());
		medicines.setMedicineName(medicinesBean.getMedicineName());
		medicines.setManifactureDate(medicinesBean.getManifactureDate());
		medicines.setExpiredDate(medicinesBean.getExpiredDate());
		medicines.setCategoryName(medicinesBean.getCategoryName());
		medicines.setDescription(medicinesBean.getDescription());
		medicines.setManifacturedCompany(medicinesBean.getManifacturedCompany());
		medicines.setPrice(medicinesBean.getPrice());
		medicines.setStockStatus(medicinesBean.getStockStatus());
		return medicines;
	}

	/* (non-Javadoc)
	 * @see com.siri.esmartHealthCare.services.MedicinesService#updateMedicines(com.siri.esmartHealthCare.beans.MedicinesBean)
	 */
	@Override
	@Transactional
	public MedicinesBean updateMedicines(MedicinesBean medicinesBean) {
		Medicines medicines=mapBeanToDomain(medicinesBean);
		Medicines medicines1=mdao.updateMedicines(medicines);
		MedicinesBean mbean=mapDomainToBean(medicines1);
		return mbean;
	}

	/* (non-Javadoc)
	 * @see com.siri.esmartHealthCare.services.MedicinesService#deleteMedicines(com.siri.esmartHealthCare.beans.MedicinesBean)
	 */
	@Override
	@Transactional
	public Boolean deleteMedicines(MedicinesBean medicinesBean) {
		Medicines medicines=mapBeanToDomain(medicinesBean);
		mdao.deleteMedicines(medicines);
		return null;
	}

	/* (non-Javadoc)
	 * @see com.siri.esmartHealthCare.services.MedicinesService#getMedicinesByName(java.lang.String)
	 */
	@Override
	public MedicinesBean getMedicinesByName(String medicineName) {
		Medicines medicines=mdao.getMedicinesByName(medicineName);
		MedicinesBean mdbean=mapDomainToBean(medicines);
		return mdbean;
	}

	private MedicinesBean mapDomainToBean(Medicines medicines) {
		MedicinesBean mdbean=new MedicinesBean();
		mdbean.setMedicineId(medicines.getMedicineId());
		mdbean.setMedicineName(medicines.getMedicineName());
		mdbean.setManifactureDate(medicines.getManifactureDate());
		mdbean.setExpiredDate(medicines.getExpiredDate());
		mdbean.setCategoryName(medicines.getCategoryName());
		mdbean.setDescription(medicines.getDescription());
		mdbean.setManifacturedCompany(medicines.getManifacturedCompany());
		mdbean.setPrice(medicines.getPrice());
		mdbean.setStockStatus(medicines.getStockStatus());
		return mdbean;
	}

	/* (non-Javadoc)
	 * @see com.siri.esmartHealthCare.services.MedicinesService#getMedicinesById(int)
	 */
	@Override
	public MedicinesBean getMedicinesById(int medicineId) {
	Medicines medicines=mdao.getMedicinesById(medicineId);
	MedicinesBean mdbean=mapDomainToBean(medicines);
		return mdbean;
	}

	/* (non-Javadoc)
	 * @see com.siri.esmartHealthCare.services.MedicinesService#getAllMedicines()
	 */
	@Override
	public List<MedicinesBean> getAllMedicines() {
		List<Medicines> medlist=mdao.getAllMedicines();
		List<MedicinesBean> medBeanList=new ArrayList<MedicinesBean>();
		for(Medicines medicines:medlist){
			MedicinesBean medBean=mapDomainToBean(medicines);
			medBeanList.add(medBean);
		}
		return medBeanList;
	}

	/* (non-Javadoc)
	 * @see com.siri.esmartHealthCare.services.MedicinesService#searchAllMedicines(int, java.lang.String)
	 */
	@Override
	public List<MedicinesBean> searchAllMedicines(int medicineId,
			String medicineName) {
		List<Medicines> mlist=mdao.searchAllMedicines(medicineId, medicineName);
		List<MedicinesBean> mbeanlist=new ArrayList<MedicinesBean>();
		for(Medicines medicines:mlist){
			MedicinesBean mbean=mapDomainToBean(medicines);
			mbeanlist.add(mbean);	
		}
		return mbeanlist;

	}

	@Override
	public List<MedicinesBean> getMedicinesByDate(String date) {
		//Date date1 = new Date("");
		List<MedicinesBean> mlist = null;
		
		 Date date1=new Date(date); 
		List<Medicines> medicines=mdao.getMedicinesByDate(date1);
		 mlist=new ArrayList<MedicinesBean>();
		for(Medicines md:medicines){
			MedicinesBean mdbean=mapDomainToBean(md);	
			mlist.add(mdbean);
		}
		
		return mlist;
	}

}
