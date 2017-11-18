package com.dotridge.nhc.persistence.dao;

import java.util.List;

import com.dotridge.nhc.persistence.entity.Hospital;

public interface HospitalDao {
	public Hospital addHospital(final Hospital hospital);

	public Hospital updateHospital(final Hospital hospital);

	public Hospital getHospitalById(final int id);

	public boolean deleteHospital(final int id);

	public List<Hospital> getHospitalByName(final String name);

	public List<Hospital> getAllHospitals();

	public List<Hospital> getAllHospitalsByPaging(final int currentPage,final int noOfRecordsForPage);
	
	public void updateHospitalStatus(final int hospId);
	
	public List<Hospital> searchHospital(final String searchKey,final String searchValue);
	
	public boolean   multiSelectHospitalDbOpeations(final List<Integer> paramList);

}
