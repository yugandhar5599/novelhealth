package com.dotridge.service;

import java.util.List;

import com.dotridge.bean.NurseBean;
import com.dotridge.domain.Nurse;

public interface NurseServive {
	
	public Nurse mapBeanToDomain(NurseBean nurseBean);
	
	public NurseBean mapDomainToBean(Nurse nurseDomain);
	
	public NurseBean createNurse(NurseBean nurseBean);
	
	public NurseBean updateNurse(int id);
	
	public NurseBean getNurseById(int id);
	
	public List<NurseBean> getNurseName(String firstName);
	
	public List<NurseBean> getAllNurses();
	
	public boolean deleteNurse(int id);
	
	public List<NurseBean> getAllAdminsByPagining(int currentPage, int numberOfRecords);


}
