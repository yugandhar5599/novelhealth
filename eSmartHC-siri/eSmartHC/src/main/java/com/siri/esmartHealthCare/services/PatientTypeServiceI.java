/**
 * 
 */
package com.siri.esmartHealthCare.services;

import java.util.List;

import com.siri.esmartHealthCare.beans.PatientTypeBean;

/**
 * @author VENU
 *
 */
public interface PatientTypeServiceI {
	public PatientTypeBean addPatientType(PatientTypeBean ptypeBean);
	public PatientTypeBean updatePatientType(PatientTypeBean ptypeBean);
	public Boolean deletePatientType(PatientTypeBean ptypeBean);
	public PatientTypeBean getPatientTypeByName(String name);
	public PatientTypeBean getPatientTypeById(int id);
	public List<PatientTypeBean> getAllPatientTypes();
	public List<PatientTypeBean> searchPatientType(String tyname, int id);

}
