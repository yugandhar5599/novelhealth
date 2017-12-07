package com.siri.esmartHealthCare.beans;

import java.util.Date;
import java.util.List;

public class PrescriptionBean {
	private int prescriptionId;
	private List<String> prescriptionlist;
	private Date prescriptionDate;
	
	/*public PrescriptionBean(int prescriptionId,List<String> prescriptionlist) {
		this.prescriptionId = prescriptionId;
		this.prescriptionlist = prescriptionlist;
		//this.prescriptionDate = prescriptionDate;
	}
*/	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
	}
	public PrescriptionBean() {
	
}
	public void setPrescriptionlist(List<String> prescriptionlist) {
		this.prescriptionlist = prescriptionlist;
	}
	public void setPrescriptionDate(Date prescriptionDate) {
		this.prescriptionDate = prescriptionDate;
	}
	/*public PrescriptionBean(int prescriptionId) {
		this.prescriptionId = prescriptionId;
		//this.prescriptionlist = prescriptionlist;
		//this.prescriptionDate = prescriptionDate;
	}*/

	public int getPrescriptionId() {
		return prescriptionId;
	}

	public List<String> getPrescriptionlist() {
		return prescriptionlist;
	}

	public Date getPrescriptionDate() {
		return prescriptionDate;
	}
	
	//private List<>
	/*
	public int getPrescriptionId() {
		return prescriptionId;
	}
	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
	}
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	public Date getPrescriptionDate() {
		return prescriptionDate;
	}
	public void setPrescriptionDate(Date prescriptionDate) {
		this.prescriptionDate = prescriptionDate;
	}*/
	

}
