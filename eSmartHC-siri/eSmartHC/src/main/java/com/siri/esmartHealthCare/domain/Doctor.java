/**
 * 
 */
package com.siri.esmartHealthCare.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author VENU
 *
 */
@Entity
public class Doctor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 890903963797183669L;
	
	@Id
	@GeneratedValue
	private int docId;
	private String name;
	private Date regDate;
	private long mobileno;
	private String email;
	private Date dateofbirth;
	private String gender;
	private long regId;
	
	@OneToOne
	private Department specialization;
	
	public Department getSpecialization() {
		return specialization;
	}
	public void setSpecialization(Department specialization) {
		this.specialization = specialization;
	}
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Patient> patientsList;
	public List<Patient> getPatientsList() {
		return patientsList;
	}
	public void setPatientsList(List<Patient> patientsList) {
		this.patientsList = patientsList;
	}
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
		public long getRegId() {
		return regId;
	}
	public void setRegId(long regId) {
		this.regId = regId;
	}
	
	
	
	

}
