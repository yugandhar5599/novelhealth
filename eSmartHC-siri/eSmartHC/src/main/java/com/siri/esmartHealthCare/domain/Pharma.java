/**
 * 
 */
package com.siri.esmartHealthCare.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author VENU
 *
 */
@Entity
public class Pharma {
	@Id
	@GeneratedValue
	private int pharmaId;
	
	private String pharmaName;
	private String email;
	private long mobileno;
	public int getPharmaId() {
		return pharmaId;
	}
	public void setPharmaId(int pharmaId) {
		this.pharmaId = pharmaId;
	}
	public String getPharmaName() {
		return pharmaName;
	}
	public void setPharmaName(String pharmaName) {
		this.pharmaName = pharmaName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	
	 

}
