/**
 * 
 */
package com.siri.esmartHealthCare.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author VENU
 *
 */
@Entity
@Table(name="Patient123")
public class Patient implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1527191059810871171L;
	@Id
	@GeneratedValue
	private int pid;
	private String pname;
	private String gender;
	private String createdBy;
	private String modifiedBy;
	private String email;
	private long mobile;
	/*
	@Temporal(TemporalType.DATE)
	private Date dateofbirth;
	
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	@Temporal(TemporalType.DATE)
	private Date lastModifiedDate;*/
	@OneToOne
	private RoleDomaine role;
	
	@ManyToOne
	private Doctor doc;
	
	@OneToOne
	private PatientType pType;
	
	@OneToOne
	private Laboratory lab;
	
	
	
	public RoleDomaine getRole() {
		return role;
	}
	public void setRole(RoleDomaine role) {
		this.role = role;
	}
	public Bed_Patient getBed() {
		return bed;
	}
	public void setBed(Bed_Patient bed) {
		this.bed = bed;
	}
	@OneToOne(mappedBy="bed",cascade=CascadeType.ALL)
	private Bed_Patient bed;
	
	public Laboratory getLab() {
		return lab;
	}
	public void setLab(Laboratory lab) {
		this.lab = lab;
	}
	public Doctor getDoc() {
		return doc;
	}
	public void setDoc(Doctor doc) {
		this.doc = doc;
	}
	public PatientType getpType() {
		return pType;
	}
	public void setpType(PatientType pType) {
		this.pType = pType;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	/*public Date getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}*/
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	/*public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}*/
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	
	
	

}
