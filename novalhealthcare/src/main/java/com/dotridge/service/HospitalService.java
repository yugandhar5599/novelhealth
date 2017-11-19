package com.dotridge.service;

import java.util.List;

import com.dotridge.bean.HospitalBean;
import com.dotridge.domain.Hospital;

public interface HospitalService {
	public HospitalBean addHospital(HospitalBean hostpitalBean);

	public HospitalBean updateHospital(HospitalBean hospitalBean);

	public boolean deleteHospital(int hospitalId);

	public boolean activateHospital(int hospitalId);

	public boolean inactivateHospital(int hospitalId);

	public List<HospitalBean> getAllHospital();

	public List<HospitalBean> searchHospital(String hospitalName, String address1, String email, long phone,
			boolean status);

	public HospitalBean getHospitalById(int hospitalId);

	public List<HospitalBean> getHospitalByName(String hospitalName);

	public List<HospitalBean> getHospitalByEmail(String email);

	List<HospitalBean> getAllHospitalsByPaging(int currPage, int noOfRecPage);

}
