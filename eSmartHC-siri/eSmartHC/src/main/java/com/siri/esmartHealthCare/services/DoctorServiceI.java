
/**
 * 
 */
package com.siri.esmartHealthCare.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.siri.esmartHealthCare.beans.DoctorBean;
import com.siri.esmartHealthCare.domain.Doctor;

/**
 * @author VENU
 *
 */
//@Service
public interface DoctorServiceI {

	public DoctorBean addDoctor(DoctorBean doctBean);
	public void updateDoctor(DoctorBean doctBean);
	public Boolean deleteDoctor(DoctorBean doctBean);
	public String deleteDoctor(int docId);
	public DoctorBean getDoctorById(int docId);
	public DoctorBean getDoctorByName(String name);
	public List<DoctorBean> getAllDoctors();
	public List<DoctorBean> searchAllDoctors(int id,String name);
		
}
