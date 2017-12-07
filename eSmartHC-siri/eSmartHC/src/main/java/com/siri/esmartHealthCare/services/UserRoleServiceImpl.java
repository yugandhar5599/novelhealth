/**
 * 
 */
package com.siri.esmartHealthCare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siri.esmartHealthCare.beans.PrescriptionBean;
import com.siri.esmartHealthCare.beans.UserRoleBean;
import com.siri.esmartHealthCare.dao.UserRoleDaoI;
import com.siri.esmartHealthCare.domain.Prescription;
import com.siri.esmartHealthCare.domain.UserRoles;

/**
 * @author VENU
 *
 */
@Service
public class UserRoleServiceImpl implements UserRoleServiceI {
	
	@Autowired
	private UserRoleDaoI dao;

	public UserRoleBean addUserRole(UserRoleBean userbean) {
		UserRoles userrole=mapBeanToDomain(userbean);
		dao.addUserRoles(userrole);
		return null;
	}
	private UserRoles mapBeanToDomain(UserRoleBean userbean) {
		UserRoles userrole=new UserRoles();
		if(userbean == null)
			throw new RuntimeException("UserRoles ionformation not foumd");
		userrole.setRoleName(userbean.getRoleName());

		//prcdomain.setPrescription(prescription.getPrescriptionlist());
		return userrole;
	}
	public UserRoleBean updateUserRole(UserRoleBean userbean) {
		// TODO Auto-generated method stub
		return null;
	}
	public Boolean deleteUserRole(UserRoleBean userbean) {
		// TODO Auto-generated method stub
		return null;
	}
	public UserRoleBean getUserRoleByName(String roleName) {
		// TODO Auto-generated method stub
		return null;
	}
	public UserRoleBean getUserRoleById(int roleId) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<UserRoleBean> getAllUserRole() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<UserRoleBean> searchAllUserRoles(int roleId, String roleName) {
		// TODO Auto-generated method stub
		return null;
	}


}
