/**
 * 
 */
package com.siri.esmartHealthCare.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author VENU
 *
 */
@Entity
public class PatientType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7080856583732802494L;
	
	@Id
	@GeneratedValue
	private int ptypeId;
	private String type;
	public int getPtypeId() {
		return ptypeId;
	}
	public void setPtypeId(int ptypeId) {
		this.ptypeId = ptypeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
