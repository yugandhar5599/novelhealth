package com.dotridge.dao;

import java.util.List;

import com.dotridge.domain.Hospital;

public interface HospitalDao {

	public Hospital addHospital(Hospital hostpital);
	
	public Hospital updateHospital(Hospital hostpital);
	
	public boolean deleteHospital(int hospitalId);

	public boolean activateHospital(int hospitalId);

	public boolean inactivateHospital(int hospitalId);

	public List<Hospital> getAllHospital();

	public List<Hospital> searchHospital(String hospitalName, String address1, String email, long phone,
			boolean status);

	public Hospital getHospitalById(int hospitalId);
	public Hospital getHospitalNames(String hospitalName);
	
	public List<Hospital> getHospitalByName(String hospitalName);
	public List<Hospital> getHospitalByEmail(String email);

	public List<Hospital> getAllHospitalsByPaging(int currPage, int noOfRecPage);
	
	public List<Hospital> searchHospitalByName(String hospitalName);

	public List<Hospital> searchHospitalByEmail(String searchValue);

	public List<Hospital> searchHospitalByAddress1(String address1);

	public List<Hospital> searchHospitalByPhone(long phone);

	public List<Hospital> searchHospitalByStatus(String status);

}
