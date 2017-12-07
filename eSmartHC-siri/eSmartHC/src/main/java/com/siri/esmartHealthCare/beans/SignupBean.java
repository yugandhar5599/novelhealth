/**
 * 
 */
package com.siri.esmartHealthCare.beans;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.format.annotation.NumberFormat;


/**
 * @author VENU
 *
 */
public class SignupBean {

	@NotEmpty
	private String firstname;
	private String middlename;
	@NotEmpty
	private String lastname;
	@Email
	private String email;
	@NotEmpty
	private String userid;
	@Size(min=2,max=10)
	private String password;
	//@NotEmpty
	@Pattern(regexp="(^$|[0-9]{10})")
	private String mobilenumber;
	private String gender;
	private String department;
	private String role;
	private String acceptTerm;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
	
	
	

}
