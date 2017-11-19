package com.dotridge.service;

import java.util.List;

import com.dotridge.bean.HospitalBean;
import com.dotridge.bean.PatientBean;
import com.dotridge.domain.Patient;

public interface PatientService {
	public PatientBean addPatient(PatientBean patientBeean);

	public PatientBean updatePatient(PatientBean patientBean);

	public boolean deletePatient(int pId);
	
	public List<PatientBean> getAllPatients();
	
	public PatientBean getPatientById(int pId);
	
	public List<PatientBean> getAllPatientsByPaging(int currPage, int noOfRecPage);
}
