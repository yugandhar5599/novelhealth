/**
 * 
 */
package com.siri.esmartHealthCare.services;

import java.util.List;

import com.siri.esmartHealthCare.beans.PrescriptionBean;

/**
 * @author VENU
 *
 */
public interface PrescriptionServiceI {
	public PrescriptionBean addPrescription(PrescriptionBean prescription);
	public PrescriptionBean updatePrescription(PrescriptionBean prescription);
	public Boolean deletePrescription(PrescriptionBean prescription);
	public PrescriptionBean getPrescriptionByName(String prescription);
	public PrescriptionBean getPrescriptionById(int prescriptionId);
	public List<PrescriptionBean> getAllPrescription();
	public List<PrescriptionBean> searchAllPrescriptions(int id,String name);

}
