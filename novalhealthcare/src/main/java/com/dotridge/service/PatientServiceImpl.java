package com.dotridge.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotridge.bean.PatientBean;
import com.dotridge.bean.UserProfileBean;
import com.dotridge.dao.PatientDao;
import com.dotridge.domain.Hospital;
import com.dotridge.domain.Patient;
import com.dotridge.domain.UserProfile;
@Service
public class PatientServiceImpl implements PatientService{
	@Autowired
	private PatientDao patientDao;

	
	public List<PatientBean> getAllPatients() {
		System.out.println("enter into patient services");
		List<Patient>  patientslist= patientDao.getAllPatients();

		System.out.println("list of patients are" + patientslist.size());
		List<PatientBean> uipatientslist = null;

		if (patientslist != null && !patientslist.isEmpty()) {
			System.out.println("if  execution successfully");
			uipatientslist = new ArrayList<PatientBean>();
			for (Patient patient : patientslist) {
				PatientBean patientBean = mapDomainToBean(patient);
				uipatientslist.add(patientBean);
			}
			System.out.println(uipatientslist.size());
			return uipatientslist;
		} else {
			// System.out.println("else block executed");
			// throw new RuntimeException("No Hosp are available");

		}
		return uipatientslist;

	}

	
	public Patient mapBeanToDomain(PatientBean patientBean) {
		
		Patient patient=new Patient();
		if (patientBean.getpId() > 0) {

			patient.setpId(patientBean.getpId());
		}

		patient.setFirstName(patientBean.getFirstName());
		patient.setMiddleName(patientBean.getMiddleName());
		patient.setLastName(patientBean.getLastName());
		patient.setGender(patientBean.getGender());
		patient.setBloodGroup(patientBean.getBloodGroup());
		patient.setDate(new Date());
		patient.setEmail(patientBean.getEmail());
		patient.setPassword(patientBean.getPassword());
		patient.setPhone(patientBean.getPhone());
		patient.setStatus(patientBean.isStatus());
		return patient;
	}

	public PatientBean mapDomainToBean(Patient patient) {
		PatientBean patientBean=new PatientBean();
		patientBean.setpId(patient.getpId());
		patientBean.setFirstName(patient.getFirstName());
		patientBean.setMiddleName(patient.getMiddleName());
		patientBean.setLastName(patient.getLastName());
		patientBean.setGender(patient.getGender());
		patientBean.setBloodGroup(patient.getBloodGroup());
		patientBean.setDate(new Date());
		patientBean.setEmail(patient.getEmail());
		patientBean.setPassword(patient.getPassword());
		patientBean.setPhone(patient.getPhone());
		patientBean.setStatus(patient.isStatus());
		return patientBean;
	}


	public PatientBean addPatient(PatientBean patientBeean) {
		Patient patientDomain = patientDao.addPatient(mapBeanToDomain(patientBeean));

		return mapDomainToBean(patientDomain);
	}


	public PatientBean updatePatient(PatientBean patientBean) {
		Patient patientDomain = patientDao.updatePatient(mapBeanToDomain(patientBean));

		return mapDomainToBean(patientDomain);
	}


	public boolean deletePatient(int pId) {
		patientDao.deletePatient(pId);
		return false;
	}


	public List<PatientBean> getAllPatientsByPaging(int currPage, int noOfRecPage) {
		return null;
	}


	public PatientBean getPatientById(int pId) {
		return mapDomainToBean(patientDao.getPatientById(pId));
	}
}
