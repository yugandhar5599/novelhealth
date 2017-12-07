/**
 * 
 */
package com.siri.esmartHealthCare.dao;

import java.util.List;

import com.siri.esmartHealthCare.domain.Doctor;

/**
 * @author VENU
 *
 */
public interface DoctorDaoI {
	public Doctor addDoctor(Doctor doctor);
	public void updateDoctor(Doctor doctor);
	public Boolean deleteDoctor(Doctor doctor);
	public String deleteDoctor(int docId);
	public Doctor getDoctorByName(String name);
	public Doctor getDoctorById(int docId);
	public List<Doctor> getAllDoctors();
	public List<Doctor> searchAllDoctors(int id,String name);
}
