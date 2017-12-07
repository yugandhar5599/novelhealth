/**
 * 
 */
package com.siri.esmartHealthCare.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author VENU
 *
 */
@Entity
public class Laboratory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6274252366485434887L;

	@Id
	@GeneratedValue
	private int lid;
	
	private String lname;
	
	@OneToMany(mappedBy="tests",cascade=CascadeType.ALL)
	private List<LaboratoryToTests> testslist;

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	

}
