package com.siri.esmartHealthCare.services;

import java.util.List;

import com.siri.esmartHealthCare.beans.ManageUserProfileBean;
import com.siri.esmartHealthCare.beans.SignupBean;

public interface SignupServicesI {
	public List<String> getDepList(String role);
	public List<String> getRoleList();
	public Integer getRoleId();
	public String saveDetails(ManageUserProfileBean userProfBean);
	public String checkEmailExist(String emiailId);
}
