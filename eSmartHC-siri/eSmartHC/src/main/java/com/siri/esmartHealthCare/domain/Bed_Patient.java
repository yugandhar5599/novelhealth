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

import com.siri.esmartHealthCare.domain.Bed;
import com.siri.esmartHealthCare.domain.Patient;

/**
 * @author VENU
 *
 */
@Entity
public class Bed_Patient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5681330010881371959L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pbedid;
	
	@OneToOne
	private Patient patient;
	
	@OneToOne
	private Bed bed;

	public int getPbedid() {
		return pbedid;
	}

	public void setPbedid(int pbedid) {
		this.pbedid = pbedid;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Bed getBed() {
		return bed;
	}

	public void setBed(Bed bed) {
		this.bed = bed;
	}


}
