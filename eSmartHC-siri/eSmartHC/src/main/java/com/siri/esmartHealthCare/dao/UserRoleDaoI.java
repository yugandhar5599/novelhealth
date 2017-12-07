/**
 * 
 */
package com.siri.esmartHealthCare.dao;

import java.util.ArrayList;

import com.siri.esmartHealthCare.domain.Guardian;
import com.siri.esmartHealthCare.domain.UserRoles;

/**
 * @author VENU
 *
 */
public interface UserRoleDaoI {
	public void addUserRoles(UserRoles userRole);
	public void updateUserRoles(UserRoles userRole);
	public void deleteUserRoles(UserRoles userRole);
	public UserRoles getUserRoles();
	public UserRoles getUserRolesByName();
	public ArrayList<UserRoles> getAllUserRoles();
	public UserRoles searchAllGuardians(int uid,String uname);
}
