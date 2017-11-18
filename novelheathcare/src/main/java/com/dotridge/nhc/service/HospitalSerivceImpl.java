package com.dotridge.nhc.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotridge.nhc.persistence.dao.HospitalDao;
import com.dotridge.nhc.persistence.entity.Address;
import com.dotridge.nhc.persistence.entity.Hospital;
import com.dotridge.nhc.web.model.HospitalForm;

@Service("hospitalService")

@Transactional
public class HospitalSerivceImpl implements HospitalService {

	@Autowired
	private HospitalDao hospitalDao;

	@Override
	public HospitalForm createHospital(final HospitalForm hospitalBean) {
		Hospital hospitalDomain = hospitalDao.addHospital(mapHosptalBeanToHospitalDomain(hospitalBean));
		return mapHosptalDomainToHospitalBean(hospitalDomain);
	}

	@Override
	public HospitalForm updateHospital(final HospitalForm hospitalBean) {
		
		Hospital updatedHospital = hospitalDao.updateHospital(mapHosptalBeanToHospitalDomain(hospitalBean));
		return(mapHosptalDomainToHospitalBean(updatedHospital));
	}

	@Override
	public HospitalForm getHospitalById(final int id) {
		return mapHosptalDomainToHospitalBean(hospitalDao.getHospitalById(id));
	}

	@Override
	public boolean deleteHospital(final int id) {
		return hospitalDao.deleteHospital(id);
	}

	@Override
	public List<HospitalForm> getHospitalByName(final String name) {
		return null;
	}

	@Override
	public List<HospitalForm> getAllHospitals() {
		List<HospitalForm> hospitalsList = new ArrayList<HospitalForm>();
		List<Hospital> hospitalsDomainList = hospitalDao.getAllHospitals();
		for (Hospital hospitalDomain : hospitalsDomainList) {
			hospitalsList.add(mapHosptalDomainToHospitalBean(hospitalDomain));
		}
		return hospitalsList;
	}

	@Override
	public List<HospitalForm> getAllHospitalsByPaging(final int currentPage, final int noOfRecordsForPage) {
		return null;
	}

	public Hospital mapHosptalBeanToHospitalDomain(HospitalForm hospitalBean) {
		Hospital hospitalDomain = new Hospital();
		Address address = new Address();
		if(hospitalBean.getHospitalId()!=0)
		{
			hospitalDomain.setHospitalId(hospitalBean.getHospitalId());
		}
		hospitalDomain.setHospitalName(hospitalBean.getHospitalName());
		address.setAddress1(hospitalBean.getAddress1());
		address.setAddress2(hospitalBean.getAddress2());
		address.setCity(hospitalBean.getCity());
		address.setState(hospitalBean.getState());
		address.setZipCode(hospitalBean.getZipCode());
		hospitalDomain.setAddress(address);
		hospitalDomain.setPhone(hospitalBean.getPhone());
		hospitalDomain.setEmail(hospitalBean.getEmail());
		hospitalDomain.setFax(hospitalBean.getFax());
		hospitalDomain.setStatus(hospitalBean.isStatus());
		return hospitalDomain;
	}

	public HospitalForm mapHosptalDomainToHospitalBean(final Hospital hospitalDomain) {
		HospitalForm hospitalBean = new HospitalForm();
		hospitalBean.setHospitalId(hospitalDomain.getHospitalId());
		hospitalBean.setHospitalName(hospitalDomain.getHospitalName());
		hospitalBean.setAddress1(hospitalDomain.getAddress().getAddress1());
		hospitalBean.setAddress2(hospitalDomain.getAddress().getAddress2());
		hospitalBean.setCity(hospitalDomain.getAddress().getCity());
		hospitalBean.setState(hospitalDomain.getAddress().getState());
		hospitalBean.setZipCode(hospitalDomain.getAddress().getZipCode());
		hospitalBean.setPhone(hospitalDomain.getPhone());
		hospitalBean.setEmail(hospitalDomain.getEmail());
		hospitalBean.setFax(hospitalDomain.getFax());
		hospitalBean.setStatus(hospitalDomain.isStatus());
		return hospitalBean;

	}

	@Override
	public void updateHosptialStatus(final int hospId) {
		hospitalDao.updateHospitalStatus(hospId);
	}

	@Override
	public List<HospitalForm> searchHospital(final String searchKey,final String searchValue) {
		List<HospitalForm> hospitalsList = new ArrayList<HospitalForm>();
		List<Hospital> hospitalsDomainList = hospitalDao.searchHospital(searchKey, searchValue);
		for (Hospital hospitalDomain : hospitalsDomainList) {
			hospitalsList.add(mapHosptalDomainToHospitalBean(hospitalDomain));
		}
		return hospitalsList;
	}

	@Override
	public boolean multiSelectHospitalDbOpeations(final List<Integer> paramList) {
		return hospitalDao.multiSelectHospitalDbOpeations(paramList);
	}
	
}
