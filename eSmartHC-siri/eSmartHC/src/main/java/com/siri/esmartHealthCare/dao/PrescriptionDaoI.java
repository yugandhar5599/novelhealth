/**
 * 
 */
package com.siri.esmartHealthCare.dao;

import java.util.List;

import com.siri.esmartHealthCare.domain.Prescription;

/**
 * @author VENU
 *
 */
public interface PrescriptionDaoI {
	public Prescription addPrescription(Prescription prescription);
	public Prescription updatePrescription(Prescription prescription);
	public Boolean deletePrescription(Prescription prescription);
	public Prescription getPrescriptionByName(String prescription);
	public Prescription getPrescriptionById(int prescriptionId);
	public List<Prescription> getAllPrescriptions();
	public List<Prescription> searchAllPrescriptions(int id,String name);
}
