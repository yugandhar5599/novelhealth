/**
 * 
 */
package com.siri.esmartHealthCare.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author VENU
 *
 */
@Entity
@Table(name = "MANAGEUSERPROFILE")
public class ManageUserProfileDomain {
	@Id
	@GeneratedValue
	private int profileId;	
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	@Column(name = "userid")
	private String userId;
	private String password;
	private String mobilenumber;
	private String gender;
	private String acceptTerm;
	@OneToOne
	private RoleDomaine role;
	
	public RoleDomaine getRole() {
		return role;
	}
	public void setRole(RoleDomaine role) {
		this.role = role;
	}
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAcceptTerm() {
		return acceptTerm;
	}
	public void setAcceptTerm(String acceptTerm) {
		this.acceptTerm = acceptTerm;
	}
	
	
	
}
