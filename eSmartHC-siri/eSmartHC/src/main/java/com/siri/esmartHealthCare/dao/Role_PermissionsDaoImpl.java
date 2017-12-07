/**
 * 
 */
package com.siri.esmartHealthCare.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.siri.esmartHealthCare.domain.Role_Permissions;
import com.siri.esmartHealthCare.domain.UserPermissions;
import com.siri.esmartHealthCare.domain.UserRoles;


/**
 * @author VENU
 *
 */
@Repository
public class Role_PermissionsDaoImpl implements Role_PermissionsDaoI {
	
	@Autowired
	private SessionFactory sf;
	public void addRole_Permissions() {
		
		Session hsession=sf.openSession();
		Transaction txn=hsession.beginTransaction();
		Role_Permissions rper=new Role_Permissions();
		
		UserPermissions uper=(UserPermissions) hsession.get(UserPermissions.class, 1);
		UserPermissions uper2=(UserPermissions) hsession.get(UserPermissions.class, 2);
		UserPermissions uper3=(UserPermissions) hsession.get(UserPermissions.class, 3);
		
		List<UserPermissions> userlist=new ArrayList<UserPermissions>();
		userlist.add(uper);
		userlist.add(uper2);
		userlist.add(uper3);
		
		UserRoles ur=(UserRoles) hsession.get(UserRoles.class, 1);
		
		rper.setUserper(uper3);
		rper.setUserrole(ur);
		hsession.save(rper);
		txn.commit();

		

	}

	public void updateRole_Permissions() {
		// TODO Auto-generated method stub
		
	}

	public void deleteRole_Permissions() {
		// TODO Auto-generated method stub
		
	}

	
	public ArrayList<Role_Permissions> getAllRole_Permissions() {
		// TODO Auto-generated method stub
		return null;
	}

	public Role_Permissions searchAllUserPermissions(int rpid) {
		// TODO Auto-generated method stub
		return null;
	}
	public static void main(String[] args) {
		Role_PermissionsDaoImpl rpDao=new Role_PermissionsDaoImpl();
		rpDao.addRole_Permissions();
	}

	public Role_Permissions getRole_Permissions() {
		// TODO Auto-generated method stub
		return null;
	}

	public Role_Permissions getRole_PermissionsByName() {
		// TODO Auto-generated method stub
		return null;
	}

}
