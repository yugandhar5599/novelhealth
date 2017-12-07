package com.siri.esmartHealthCare.dao;

import java.util.List;

import com.siri.esmartHealthCare.domain.Patient;

public interface PatientDaoI {
	public Patient addPatient(Patient patient);
	public Patient updatePatient(Patient patient);
	public Boolean deletePatient(Patient patient);
	public Patient getPatientByName(String pname);
	public Patient getPatientById(int pid);
	public List<Patient> getAllPatients();
	public List<Patient> searchAllPatients(int id,String name);

}
