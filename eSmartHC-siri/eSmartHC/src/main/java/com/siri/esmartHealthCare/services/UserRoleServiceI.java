/**
 * 
 */
package com.siri.esmartHealthCare.services;

import java.util.List;

import com.siri.esmartHealthCare.beans.PrescriptionBean;
import com.siri.esmartHealthCare.beans.UserRoleBean;

/**
 * @author VENU
 *
 */
public interface UserRoleServiceI {
	public UserRoleBean addUserRole(UserRoleBean userbean);
	public UserRoleBean updateUserRole(UserRoleBean userbean);
	public Boolean deleteUserRole(UserRoleBean userbean);
	public UserRoleBean getUserRoleByName(String roleName);
	public UserRoleBean getUserRoleById(int roleId);
	public List<UserRoleBean> getAllUserRole();
	public List<UserRoleBean> searchAllUserRoles(int roleId,String roleName);


}
