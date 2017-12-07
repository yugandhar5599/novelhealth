/**
 * 
 */
package com.siri.esmartHealthCare.services;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.siri.esmartHealthCare.beans.PatientBean;

/**
 * @author VENU
 *
 */
@Service
public interface PatientServiceI {
	public PatientBean addPatient(PatientBean ptbean);
	public PatientBean updatePatient(PatientBean ptbean);
	public Boolean deletePatient(PatientBean ptbean);
	public PatientBean getPatientByName(String pname);
	public PatientBean getPatientById(int pid);
	
	@PreAuthorize("hasPermission('patient','view','edit')")
	public List<PatientBean> getAllPatient();
	public List<PatientBean> searchAllPatients(int id,String name);

}
