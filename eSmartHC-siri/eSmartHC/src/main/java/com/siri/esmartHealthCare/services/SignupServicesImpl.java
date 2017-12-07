package com.siri.esmartHealthCare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siri.esmartHealthCare.beans.ManageUserProfileBean;
import com.siri.esmartHealthCare.beans.RoleBean;
import com.siri.esmartHealthCare.beans.SignupBean;
import com.siri.esmartHealthCare.dao.RoleDaoI;
import com.siri.esmartHealthCare.dao.SignupDaoI;
import com.siri.esmartHealthCare.domain.ManageUserProfileDomain;
import com.siri.esmartHealthCare.domain.RoleDomaine;

@Service
public class SignupServicesImpl implements SignupServicesI{
	@Autowired
	private SignupDaoI signupDao;
	
	@Autowired
	private RoleDaoI roleDao;
	
	private ManageUserProfileDomain mapBeanToDomaine(ManageUserProfileBean manUserProBean) {
		ManageUserProfileDomain manUserProDomaine = new ManageUserProfileDomain();
		manUserProDomaine.setFirstName(manUserProBean.getFirstName());
		manUserProDomaine.setMiddleName(manUserProBean.getMiddleName());
		manUserProDomaine.setLastName(manUserProBean.getLastName());
		manUserProDomaine.setGender(manUserProBean.getGender());
		manUserProDomaine.setEmail(manUserProBean.getEmail());
		manUserProDomaine.setUserId(manUserProBean.getUserId());
		manUserProDomaine.setPassword(manUserProBean.getPassword());
		manUserProDomaine.setMobilenumber(manUserProBean.getMobilenumber());
		manUserProDomaine.setAcceptTerm(manUserProBean.getAcceptTerm());
				return manUserProDomaine;
	}
	
	@Override
	public List<String> getRoleList() {
		List<String> roleList = signupDao.getRoleList();
		return roleList;
	}

	
	@Override
	public List<String> getDepList(String role) {
		// List<DepartmentBean> deptList
		List<String> deptList = signupDao.getDepList(role);
		return deptList;
	}
	@Override
	public String saveDetails(ManageUserProfileBean userProfBean)
	{
		ManageUserProfileDomain manageUserProfDomain=mapBeanToDomaine( userProfBean);
		RoleDomaine roleDomaine = roleDao.getRoleByName();
		System.out.println(roleDomaine.getRoleId());
		manageUserProfDomain.setRole(roleDomaine);
		String msg = signupDao.saveDetails(manageUserProfDomain);
		
		return msg;
	}
	@Override
	public String checkEmailExist(String emiailId) {
		signupDao.checkEmailExist(emiailId);
		return null;
	}


	@Override
	public Integer getRoleId() {
		Integer roleId = signupDao.getRoleId();
		return roleId;
	}
	
}
