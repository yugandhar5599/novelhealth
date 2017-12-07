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

import com.siri.esmartHealthCare.domain.UserRoles;

/**
 * @author VENU
 *
 */
@Repository
public class UserRoleDaoImpl implements UserRoleDaoI {

	@Autowired
	private SessionFactory sf;

public void addUserRoles(UserRoles userRole) {
	Session hsession=sf.openSession();
	Transaction txn=hsession.beginTransaction();
	UserRoles ur=new UserRoles();
	ur.setRoleName("adminstrator");
		
	hsession.save(ur);
	txn.commit();

}

public void updateUserRoles(UserRoles userRole) {
	// TODO Auto-generated method stub
	
}

public void deleteUserRoles(UserRoles userRole) {
	// TODO Auto-generated method stub
	
}

public UserRoles getUserRoles() {
	// TODO Auto-generated method stub
	return null;
}

public UserRoles getUserRolesByName() {
	// TODO Auto-generated method stub
	return null;
}

public ArrayList<UserRoles> getAllUserRoles() {
	// TODO Auto-generated method stub
	return null;
}

public UserRoles searchAllGuardians(int uid, String uname) {
	// TODO Auto-generated method stub
	return null;
}
	
public static void main(String[] args) {
	UserRoleDaoImpl urdao=new UserRoleDaoImpl();
}
}
