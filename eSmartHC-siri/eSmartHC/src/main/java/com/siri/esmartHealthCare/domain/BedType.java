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
public class BedType implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7409985966333212315L;
	@Id
	@GeneratedValue
	private int bedTypeId;
	private String type;
	public int getBedTypeId() {
		return bedTypeId;
	}
	public void setBedTypeId(int bedTypeId) {
		this.bedTypeId = bedTypeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

}
