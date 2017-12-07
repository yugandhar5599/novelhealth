package com.siri.esmartHealthCare.beans;

import java.util.Date;

public class GuardianBean {
	private int gid;
	private String name;
	public void setGid(int gid) {
		this.gid = gid;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setMobile(long mobile) {
		this.mobile = mobile;
	}


	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}


	private String gender;
	private String email;
	private long mobile;
	private Date dateofbirth;
	
	//private PatientBeans pbean;
	
	
	/*public PatientBeans getPbean() {
		return pbean;
	}
*/
	/*public GuardianBeans(PatientBeans pbean) {
		// TODO Auto-generated constructor stub
		this.pbean=pbean;
	}*/

	/*public void setPbean(PatientBeans pbean) {
		this.pbean = pbean;
	}
*/

	/*public GuardianBean(int gid,String name,String gender,String email,long mobile) {
       this.gid=gid;
       this.name=name;
       this.gender=gender;
       this.email=email;
       this.mobile=mobile;
       
      // this.pbean=pbean;
	}
*/

	public int getGid() {
		return gid;
	}


	public String getName() {
		return name;
	}


	public String getGender() {
		return gender;
	}


	public String getEmail() {
		return email;
	}


	public long getMobile() {
		return mobile;
	}


	public Date getDateofbirth() {
		return dateofbirth;
	}

	
	/*public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	public Date getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}*/
	

}
