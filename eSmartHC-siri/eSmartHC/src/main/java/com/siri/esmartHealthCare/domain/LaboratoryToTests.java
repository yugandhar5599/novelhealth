package com.siri.esmartHealthCare.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LaboratoryToTests implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -904246839384189492L;
	@Id
	@GeneratedValue
	private int labtestid;
	
	@ManyToOne
	private Tests tests;
	
	@ManyToOne
	private Laboratory lab;

	public int getLabtestid() {
		return labtestid;
	}

	public void setLabtestid(int labtestid) {
		this.labtestid = labtestid;
	}

	public Tests getTests() {
		return tests;
	}

	public void setTests(Tests tests) {
		this.tests = tests;
	}

	public Laboratory getLab() {
		return lab;
	}

	public void setLab(Laboratory lab) {
		this.lab = lab;
	}
	

}
