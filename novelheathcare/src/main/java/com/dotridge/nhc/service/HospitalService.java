package com.dotridge.nhc.service;

import java.util.List;

import com.dotridge.nhc.web.model.HospitalForm;

public interface HospitalService {

	public HospitalForm createHospital(final HospitalForm hospitalBean);

	public HospitalForm updateHospital(final HospitalForm hospitalBean);

	public HospitalForm getHospitalById(final int id);

	public boolean deleteHospital(final int id);

	public List<HospitalForm> getHospitalByName(final String name);

	public List<HospitalForm> getAllHospitals();

	public List<HospitalForm> getAllHospitalsByPaging(final int currentPage, final int noOfRecordsForPage);
    
	public void updateHosptialStatus(final int hospId);
	
	public List<HospitalForm> searchHospital(final String searchKey,final String searchValue); 
	
	public boolean   multiSelectHospitalDbOpeations(final List<Integer> paramList);
}
