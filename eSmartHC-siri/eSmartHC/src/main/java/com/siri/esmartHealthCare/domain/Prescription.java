/**
 * 
 */
package com.siri.esmartHealthCare.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author VENU
 *
 */
@Entity
public class Prescription implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7028575757037488823L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int prescriptionId;
	private String prescription;
	
	@Temporal(TemporalType.DATE)
	private Date prescriptionDate;
	
	
	@OneToOne
	private Doctor prescriptedBy;
	
	@OneToOne
	private Patient prescriptedTo;
	public Patient getPrescriptedTo() {
		return prescriptedTo;
	}
	public void setPrescriptedTo(Patient prescriptedTo) {
		this.prescriptedTo = prescriptedTo;
	}
	public int getPrescriptionId() {
		return prescriptionId;
	}
	
	public Date getPrescriptionDate() {
		return prescriptionDate;
	}
	public void setPrescriptionDate(Date prescriptionDate) {
		this.prescriptionDate = prescriptionDate;
	}
	public Doctor getPrescriptedBy() {
		return prescriptedBy;
	}
	public void setPrescriptedBy(Doctor prescriptedBy) {
		this.prescriptedBy = prescriptedBy;
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
	
}
