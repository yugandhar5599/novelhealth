package com.siri.esmartHealthCare.beans;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class DoctorBean {
	private int docId;
	private String docName;
	private Date regDate;
	private long mobilenumber;
	private String email;
	private Date dateOfBirth;
	private String gender;
	private long regId;
	
	public Map<BedTypeBean,BedBean> bedallocation;
	public Map<BedTypeBean, BedBean> getBedallocation() {
		return bedallocation;
	}
	public void setBedallocation(Map<BedTypeBean, BedBean> bedallocation) {
		this.bedallocation = bedallocation;
	}
	/*public List<DepartmentBean> getDept() {
		return dept;
	}
	public void setDept(List<DepartmentBean> dept) {
		this.dept = dept;
	}
	private List<DepartmentBean> dept;*/
	private DepartmentBean specialization;
	
	public DepartmentBean getSpecialization() {
		return specialization;
	}
	public void setSpecialization(DepartmentBean specialization) {
		this.specialization = specialization;
	}
	private PrescriptionBean prscb;
	
	
	public PrescriptionBean getPrscb() {
		return prscb;
	}
	/*public DoctorBean(PrescriptionBean prscb) {
	
		this.prscb = prscb;
	}*/
	/*
	public DepartmentBeans getDept() {
		return dept;
	}
	public void setDept(DepartmentBeans dept) {
		this.dept = dept;
	}*/
	private Properties props;
	
	public Properties getProps() {
		return props;
	}
	public void setProps(Properties props) {
		this.props = props;
	}
	private Map<Integer,String> nurseMap;
	
	
	public Map<Integer, String> getNurseMap() {
		return nurseMap;
	}
	public void setNurseMap(Map<Integer, String> nurseMap) {
		this.nurseMap = nurseMap;
	}
	public Set<String> getPlist() {
		return plist;
	}
	public void setPlist(Set<String> plist) {
		this.plist = plist;
	}
	private Set<String>  plist;
	
	
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public long getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	


}
