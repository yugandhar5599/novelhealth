/**
 * 
 */
package com.siri.esmartHealthCare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siri.esmartHealthCare.beans.UserPermissionsBean;
import com.siri.esmartHealthCare.dao.UserPermissionsDaoI;
import com.siri.esmartHealthCare.domain.UserPermissions;

/**
 * @author VENU
 *
 */
@Service
public class UserPermissionsServiceimpl implements UserPermissionsService {
	
	@Autowired
	private UserPermissionsDaoI dao;
	
	public UserPermissionsBean addUserPermissions(
			UserPermissionsBean userPermbean) {
		UserPermissions userperm=mapBeanToDomain(userPermbean);
		dao.addUserPermissions(userperm);
		return null;
	}

	private UserPermissions mapBeanToDomain(UserPermissionsBean userPermbean) {
		UserPermissions userperm=new UserPermissions();
		userperm.setPermissionName(userPermbean.getPermissionName());
		return userperm;
	}

	public UserPermissionsBean updateUserPermissions(
			UserPermissionsBean userPermbean) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean deleteUserPermissions(UserPermissionsBean userPermbean) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserPermissionsBean getUserPermissionsByName(String userperm) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserPermissionsBean getUserPermissionsById(int userpermId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UserPermissionsBean> getAllUserPermissions() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UserPermissionsBean> searchAllUserPermissions(int userpermId,
			String userperm) {
		// TODO Auto-generated method stub
		return null;
	}

}
