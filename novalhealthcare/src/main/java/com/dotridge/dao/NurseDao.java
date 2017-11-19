package com.dotridge.dao;

import java.util.List;

import com.dotridge.domain.Admin;
import com.dotridge.domain.Nurse;

public interface NurseDao {

public Nurse createNurse(Nurse nurseDomain);
	
	public Nurse updateNurse(int id);
	
	public Nurse getNurseById(int id);
	
	public List<Nurse> getNurseName(String firstName);
	
	public List<Nurse> getAllNurses();
	
	public boolean deleteNurse(int id);
	
	public List<Nurse> getAllAdminsByPagining(int currentPage, int numberOfRecords);


}
