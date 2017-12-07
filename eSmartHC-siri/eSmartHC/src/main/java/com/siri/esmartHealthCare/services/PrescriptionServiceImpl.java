/**
 * 
 */
package com.siri.esmartHealthCare.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PreRemove;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siri.esmartHealthCare.beans.PrescriptionBean;
import com.siri.esmartHealthCare.dao.PrescriptionDaoI;
import com.siri.esmartHealthCare.domain.Prescription;

/**
 * @author VENU
 *
 */
@Service
public class PrescriptionServiceImpl implements PrescriptionServiceI {
	@Autowired
	private PrescriptionDaoI dao;

	public PrescriptionBean addPrescription(PrescriptionBean prescription) {
		Prescription prescriptiondomain=mapBeanToDomain(prescription);
		return null;
	}

	private Prescription mapBeanToDomain(PrescriptionBean prescription) {
		Prescription prcdomain=new Prescription();
		prcdomain.setPrescriptionDate(prescription.getPrescriptionDate());
		//prcdomain.setPrescription(prescription.getPrescriptionlist());
		return null;
	}

	public PrescriptionBean updatePrescription(PrescriptionBean prescription) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean deletePrescription(PrescriptionBean prescription) {
		// TODO Auto-generated method stub
		return null;
	}

	public PrescriptionBean getPrescriptionByName(String prescription) {
		Prescription prsc=dao.getPrescriptionByName(prescription);
		PrescriptionBean prscbean=mapDomainToBean(prsc);
		return null;
	}

	public PrescriptionBean getPrescriptionById(int prescriptionId) {
		Prescription prsc=dao.getPrescriptionById(prescriptionId);
		PrescriptionBean prscbean=mapDomainToBean(prsc);
		return prscbean;
	}

	public List<PrescriptionBean> getAllPrescription() {
			List<Prescription> prsclist=dao.getAllPrescriptions();
			List<PrescriptionBean> prscbeanlist=new ArrayList<PrescriptionBean>();
			for(Prescription prsc:prsclist){
				PrescriptionBean prscbean=mapDomainToBean(prsc);
				prscbeanlist.add(prscbean);
				
			}
		return prscbeanlist;
	}

	private PrescriptionBean mapDomainToBean(Prescription prsc) {
		PrescriptionBean pbean=new PrescriptionBean();
		pbean.setPrescriptionId(prsc.getPrescriptionId());
		pbean.setPrescriptionDate(prsc.getPrescriptionDate());
		
		return pbean;
	}

	public List<PrescriptionBean> searchAllPrescriptions(int id, String name) {
		List<Prescription> prslist=dao.searchAllPrescriptions(id, name);
		List<PrescriptionBean> prscbeanlist=new ArrayList<PrescriptionBean>();
		for(Prescription prsc:prslist){
			PrescriptionBean pbean=mapDomainToBean(prsc);
			prscbeanlist.add(pbean);	
		}
		return prscbeanlist;
	}

	
}
