package com.dotridge.bean;

import java.io.Serializable;

public class UserProfileBean implements Serializable {

	private static final long serialVersionUID = 5717129619970470832L;

	private String hospitalName;
	private int adminId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String password;
	private String phone;
	private boolean status;
	private String profileDocument;
	
	

	public String getProfileDocument() {
		return profileDocument;
	}

	public void setProfileDocument(String profileDocument) {
		this.profileDocument = profileDocument;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "UserProfileBean [hospitalName=" + hospitalName + ", adminId=" + adminId + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", phone=" + phone + ", status=" + status + "]";
	}

	
}
