/**
 * 
 */
package com.siri.esmartHealthCare.beans;

import java.util.Date;

/**
 * @author VENU
 *
 */
public class MedicinesBean {
	
private int medicineId;
	
	private String medicineName;
	
	private Date manifactureDate;
	
	private Date expiredDate;
	private String categoryName;
	private Float price;
	private String description;
	private String stockStatus;
	private String manifacturedCompany;
	
	

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		categoryName = categoryName;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStockStatus() {
		return stockStatus;
	}

	public void setStockStatus(String stockStatus) {
		this.stockStatus = stockStatus;
	}

	public String getManifacturedCompany() {
		return manifacturedCompany;
	}

	public void setManifacturedCompany(String manifacturedCompany) {
		this.manifacturedCompany = manifacturedCompany;
	}

	public int getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public Date getManifactureDate() {
		return manifactureDate;
	}

	public void setManifactureDate(Date manifactureDate) {
		this.manifactureDate = manifactureDate;
	}

	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}
	
}
