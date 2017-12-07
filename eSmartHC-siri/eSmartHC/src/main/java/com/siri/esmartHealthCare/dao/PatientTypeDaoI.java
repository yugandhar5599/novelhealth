/**
 * 
 */
package com.siri.esmartHealthCare.dao;

import java.util.List;

import com.siri.esmartHealthCare.beans.PatientTypeBean;
import com.siri.esmartHealthCare.domain.PatientType;

/**
 * @author VENU
 *
 */
public interface PatientTypeDaoI {
	public PatientType addPatientType(PatientType ptype);
	public PatientType updatePatientType(PatientType ptype);
	public Boolean deletePatientType(PatientType ptype);
	public PatientType getPatientTypeByName(String name);
	public PatientType getPatientTypeById(int id);
	public List<PatientType> getAllPatientType();
	public List<PatientType> searchPatientType(String tyname,int id);

}
