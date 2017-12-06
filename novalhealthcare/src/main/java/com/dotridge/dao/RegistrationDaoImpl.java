package com.dotridge.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dotridge.domain.UserProfile;

@Repository
public class RegistrationDaoImpl implements RegistrationDao 
{
	@Autowired
	private SessionFactory sessionFactory;

	public UserProfile createUser(UserProfile user) 
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		return user;
	}
}
