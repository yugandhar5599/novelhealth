/**
 * 
 */
package com.siri.esmartHealthCare.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.siri.esmartHealthCare.beans.DoctorBean;
import com.siri.esmartHealthCare.beans.PharmaBean;
import com.siri.esmartHealthCare.dao.DoctorDaoI;
import com.siri.esmartHealthCare.dao.PharmaDao;
import com.siri.esmartHealthCare.domain.Doctor;
import com.siri.esmartHealthCare.domain.Pharma;

/**
 * @author VENU
 *
 */
@Service
public class PharmaServiceImpl implements PharmaService {

	@Autowired	
	private PharmaDao dao;
	
	@Override
	public PharmaBean addPharma(PharmaBean pharmaBean) {
		Pharma pharma = mapBeanToDomain(pharmaBean);
		Pharma pharma1 = dao.addPharma(pharma);
		if(pharma1.getPharmaId() > 0){
			System.out.println("Pharma saved successfully");
		}
		PharmaBean pbean=mapDomainToBean(pharma1);
		return pbean;
	}

	private Pharma mapBeanToDomain(PharmaBean pharmaBean) {
		Pharma pharma=new Pharma();
		pharma.setPharmaId(pharmaBean.getPharmaId());
		pharma.setPharmaName(pharmaBean.getPharmaName());
		pharma.setEmail(pharmaBean.getEmail());
		pharma.setMobileno(pharmaBean.getMobileno());
		return pharma;
	}

	@Override
	@Transactional
	public PharmaBean updatePharma(PharmaBean pharmaBean) {
		System.out.println("service"+pharmaBean.getPharmaId());
		Pharma pharma = mapBeanToDomain(pharmaBean);
		System.out.println("service2"+pharma.getPharmaId());
		Pharma pharma1=dao.updatePharma(pharma);
		PharmaBean pharmabean=mapDomainToBean(pharma1);
		return pharmabean;
	}

	private PharmaBean mapDomainToBean(Pharma pharma1) {
		PharmaBean pbean=new PharmaBean();
		pbean.setPharmaId(pharma1.getPharmaId());
		pbean.setPharmaName(pharma1.getPharmaName());
		pbean.setEmail(pharma1.getEmail());
		pbean.setMobileno(pharma1.getMobileno());
		return pbean;
	}

	@Override
	@Transactional
	public Boolean deletePharma(PharmaBean pharmaBean) {
		Pharma pharma = mapBeanToDomain(pharmaBean);
		dao.deletePharma(pharma);
		return true;
	}

	@Override
	public PharmaBean getPharmaById(int pharmaId) {
		Pharma pharma=dao.getPharmaById(pharmaId);
		PharmaBean pbean=mapDomainToBean(pharma);
		return pbean;
	}

	@Override
	public PharmaBean getPharmaByName(String pharmaName) {
		Pharma pharma=dao.getPharmaByName(pharmaName);
		PharmaBean pbean=mapDomainToBean(pharma);
		return pbean;
	}

	@Override
	public List<PharmaBean> getAllPharmas() {
		List<Pharma> pharmaList=dao.getAllPharmas();
		List<PharmaBean> pblist=new ArrayList<PharmaBean>();
		for(Pharma pharma:pharmaList){
			PharmaBean pbean=mapDomainToBean(pharma);
			pblist.add(pbean);
		}
			return pblist;
	}

	@Override
	public List<PharmaBean> searchAllPharmas(int pharmaId, String pharmaName) {
		List<Pharma> pharmalist=dao.searchAllPharmas(pharmaId, pharmaName);
		List<PharmaBean> pharmaBeanlist=new ArrayList<PharmaBean>();
		for(Pharma pharma:pharmalist){
			PharmaBean pbean=mapDomainToBean(pharma);
			pharmaBeanlist.add(pbean);
			
		}
			return pharmaBeanlist;
	}

	@Override
	@Transactional
	public Boolean deletePharma(int pharmaId) {
		dao.deletePharma(pharmaId);
		return null;
	}

}
