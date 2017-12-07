package com.siri.esmartHealthCare.dao;

import java.util.List;

import com.siri.esmartHealthCare.beans.ManageUserProfileBean;
import com.siri.esmartHealthCare.beans.SignupBean;
import com.siri.esmartHealthCare.domain.ManageUserProfileDomain;

public interface SignupDaoI {
public List<String> getDepList(String role);
public List<String> getRoleList();
public Integer getRoleId();
public String saveDetails(ManageUserProfileDomain userProfDomaine);
public String checkEmailExist(String emiailId);
}
