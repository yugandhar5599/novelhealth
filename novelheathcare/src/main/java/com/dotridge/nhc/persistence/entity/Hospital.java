/**
 * 
 */
package com.dotridge.nhc.persistence.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author lenovo
 *
 */
@Entity
@Table(name = "hospital_table")
public class Hospital implements Serializable {

	private static final long serialVersionUID = -2867534038449693384L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "hospital_id")
	private Integer hospitalId;

	@Column(name = "hospital_name", nullable = true)
	private String hospitalName;

	@Column(name = "email", nullable = true)
	private String email;

	@Column(name = "phone_no", nullable = true)
	private Long phone;

	@Column(name = "fax", nullable = true)
	private Long fax;

	@Column(name = "logo", nullable = true)
	private String logo;

	@Column(name = "registration_docs", nullable = true)
	private String registrationDocs;

	@Column(name = "status", nullable = true, columnDefinition = "TINYINT", length = 1)
	private boolean status;

	@OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
	@JoinColumn(name="address_id_fk")
	private Address address;

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Long getFax() {
		return fax;
	}

	public void setFax(Long fax) {
		this.fax = fax;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getRegistrationDocs() {
		return registrationDocs;
	}

	public void setRegistrationDocs(String registrationDocs) {
		this.registrationDocs = registrationDocs;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Hospital [hospitalId=" + hospitalId + ", hospitalName=" + hospitalName + ", email=" + email + ", phone=" + phone + ", fax=" + fax
				+ ", logo=" + logo + ", registrationDocs=" + registrationDocs + ", status=" + status + ", address=" + address + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fax == null) ? 0 : fax.hashCode());
		result = prime * result + ((hospitalId == null) ? 0 : hospitalId.hashCode());
		result = prime * result + ((hospitalName == null) ? 0 : hospitalName.hashCode());
		result = prime * result + ((logo == null) ? 0 : logo.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((registrationDocs == null) ? 0 : registrationDocs.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hospital other = (Hospital) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fax == null) {
			if (other.fax != null)
				return false;
		} else if (!fax.equals(other.fax))
			return false;
		if (hospitalId == null) {
			if (other.hospitalId != null)
				return false;
		} else if (!hospitalId.equals(other.hospitalId))
			return false;
		if (hospitalName == null) {
			if (other.hospitalName != null)
				return false;
		} else if (!hospitalName.equals(other.hospitalName))
			return false;
		if (logo == null) {
			if (other.logo != null)
				return false;
		} else if (!logo.equals(other.logo))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (registrationDocs == null) {
			if (other.registrationDocs != null)
				return false;
		} else if (!registrationDocs.equals(other.registrationDocs))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

}
