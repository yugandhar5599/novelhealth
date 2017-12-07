package com.siri.esmartHealthCare.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.siri.esmartHealthCare.domain.ManageUserProfileDomain;
@Repository
public class LoginDaoImpl implements LoginDaoI {

	@Autowired
	private SessionFactory sf;
	
	
	@Override
	public String getRoleNameByUserId(String userName) {
		Session hSession = sf.openSession();
		Query query = hSession.createQuery("from ManageUserProfileDomain where userId=?");
		query.setParameter(0, userName);
		ManageUserProfileDomain manUserProDomaine = (ManageUserProfileDomain)query.uniqueResult();
		String roleName = manUserProDomaine.getRole().getRoleName();
		System.out.println("roleName  "+roleName);
		return roleName;
	}

}
