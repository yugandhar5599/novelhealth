/**
 * 
 */
package com.siri.esmartHealthCare.services;

import java.util.List;

import com.siri.esmartHealthCare.beans.UserPermissionsBean;


/**
 * @author VENU
 *
 */
public interface UserPermissionsService {
	public UserPermissionsBean addUserPermissions(UserPermissionsBean userPermbean);
	public UserPermissionsBean updateUserPermissions(UserPermissionsBean userPermbean);
	public Boolean deleteUserPermissions(UserPermissionsBean userPermbean);
	public UserPermissionsBean getUserPermissionsByName(String userperm);
	public UserPermissionsBean getUserPermissionsById(int userpermId);
	public List<UserPermissionsBean> getAllUserPermissions();
	public List<UserPermissionsBean> searchAllUserPermissions(int userpermId,String userperm);


}
