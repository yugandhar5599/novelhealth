/**
 * 
 */
package com.siri.esmartHealthCare.dao;

import java.util.ArrayList;

import com.siri.esmartHealthCare.domain.Guardian;
import com.siri.esmartHealthCare.domain.UserPermissions;
import com.siri.esmartHealthCare.domain.UserRoles;

/**
 * @author VENU
 *
 *
 *
 */
public interface UserPermissionsDaoI {
	public void addUserPermissions(UserPermissions userperm);
	public void updateUserPermissions(UserPermissions userperm);
	public void deleteUserPermissions(UserPermissions userperm);
	public UserPermissions getUserPermissionsById(int userpermId);
	public UserPermissions getUserPermissionsByName(String userpermName);
	public ArrayList<UserPermissions> getAllUserPermissions();
	public UserPermissions searchAllUserPermissions(int userpermId,String name);
}
