package com.dotridge.dao;

import java.util.List;

import com.dotridge.domain.Hospital;
import com.dotridge.domain.Patient;

public interface PatientDao {
	public Patient addPatient(Patient patient);

	public Patient updatePatient(Patient patient);

	public boolean deletePatient(int pId);
	
	public List<Patient> getAllPatients();
	
	public Patient getPatientById(int pId);
	
	public List<Patient> getAllPatientsByPaging(int currPage, int noOfRecPage);
}
