package com.siri.esmartHealthCare.beans;

import java.util.Date;
import java.util.List;

import org.w3c.dom.ls.LSInput;

public class PatientBean {
	private int pid;
	private String pname;
	private Date dateofbirth;
	private String gender;
	private Date createdDate;
	private String createdBy;
	private Date lastModifiedDate;
	private String modifiedBy;
	private String email;
	private long mobile;
	private String role;
	
	public PatientTypeBean getPtype() {
		return ptype;
	}

	
	
	
	private PatientTypeBean ptype;
	
	public void setPtype(PatientTypeBean ptype) {
		this.ptype = ptype;
	}

	/*public PatientBeans(PatientTypeBeans ptype) {
		this.ptype=ptype;
	}
	*/
	private GuardianBean gbean;
	
	/*public PatientBean(GuardianBean gbean) {
		this.gbean=gbean;
	}
	*/
	
	public void setGbean(GuardianBean gbean) {
		this.gbean = gbean;
	}



	public GuardianBean getGbean() {
		return gbean;
	}



/*	public void setGbean(GuardianBeans gbean) {
		this.gbean = gbean;
	}
*/
	private List<PrescriptionBean> prslist;
	/*public PatientBean(List<PrescriptionBean> prslist) {
		this.prslist=prslist;
	}
	*/
	

	public List<PrescriptionBean> getPrslist() {
		return prslist;
	}



	public void setPrslist(List<PrescriptionBean> prslist) {
		this.prslist = prslist;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
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
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Date getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	
	public Date getCreatedDate() {
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
