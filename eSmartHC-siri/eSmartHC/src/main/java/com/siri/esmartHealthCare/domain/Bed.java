/**
 * 
 */
package com.siri.esmartHealthCare.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author VENU
 *
 */
@Entity
public class Bed implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8957850691034347021L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bid;
	private double costperday;
	private boolean availability;
	
	@OneToOne
	private BedType bedtype;
	
	@OneToOne(mappedBy="patient")
	private Bed_Patient patient;
	
	
	public Bed_Patient getPatient() {
		return patient;
	}
	public void setPatient(Bed_Patient patient) {
		this.patient = patient;
	}
	public BedType getBedtype() {
		return bedtype;
	}
	public void setBedtype(BedType bedtype) {
		this.bedtype = bedtype;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public double getCostperday() {
		return costperday;
	}
	public void setCostperday(double costperday) {
		this.costperday = costperday;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	 
}
