/**
 * 
 */
package com.siri.esmartHealthCare.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.siri.esmartHealthCare.domain.Guardian;
import com.siri.esmartHealthCare.domain.UserPermissions;
import com.siri.esmartHealthCare.domain.UserRoles;

/**
 * @author VENU
 *
 */
@Repository
public class UserPermissionsDaoImpl implements UserPermissionsDaoI {
	@Autowired
	private SessionFactory sf;
	
	public void addUserPermissions(UserPermissions userperm) {

		Session hsession=sf.openSession();
		Transaction txn=hsession.beginTransaction();
		UserPermissions up=new UserPermissions();
		up.setPermissionName("readwrite");
			
		hsession.save(up);
		txn.commit();

		
	}

	public void updateUserPermissions(UserPermissions userperm) {
	
		
	}

	public void deleteUserPermissions(UserPermissions userperm) {
		// TODO Auto-generated method stub
		
	}

	public UserPermissions getUserPermissionsById(int userpermId) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserPermissions getUserPermissionsByName(String userpermName) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<UserPermissions> getAllUserPermissions() {
		// TODO Auto-generated method stub
		return null;
	}

	public UserPermissions searchAllUserPermissions(int userpermId, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
