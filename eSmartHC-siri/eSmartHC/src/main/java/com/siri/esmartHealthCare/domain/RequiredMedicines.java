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
public class RequiredMedicines {
	@Id
	@GeneratedValue
	private int medicinesId;
	
	private String medicinesName;
	private String CategoryName;
	private String manifactureCompany;
	public int getMedicinesId() {
		return medicinesId;
	}
	public void setMedicinesId(int medicinesId) {
		this.medicinesId = medicinesId;
	}
	public String getMedicinesName() {
		return medicinesName;
	}
	public void setMedicinesName(String medicinesName) {
		this.medicinesName = medicinesName;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	public String getManifactureCompany() {
		return manifactureCompany;
	}
	public void setManifactureCompany(String manifactureCompany) {
		this.manifactureCompany = manifactureCompany;
	}
	
	

}
