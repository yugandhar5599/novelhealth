package com.dotridge.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.dotridge.domain.Hospital;
import com.dotridge.domain.UserProfile;
import com.dotridge.util.SessionFactoryUtil;

@Repository
public class UserDaoImpl implements UserDao {

	public List<UserProfile> getAllUsers() {
		SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		System.out.println("enter into user dao");
		Query query = session.createQuery("from UserProfile");

		List<UserProfile> listofusers = query.list();

		session.close();
		System.out.println("list of users are" + listofusers.size());
		return listofusers;
	}

	public UserProfile addUser(UserProfile userProfile) {
		SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		Transaction trasaction = session.beginTransaction();
		session.save(userProfile);
		trasaction.commit();
		session.close();
		return userProfile;
	}

	public UserProfile updateUser(UserProfile userProfile) {
		System.out.println("in hospital dao impl:\t" + userProfile.toString());
		SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		Transaction trasaction = session.beginTransaction();
		// session.saveOrUpdate(hospital);
		session.merge(userProfile);
		trasaction.commit();
		session.close();
		return userProfile;
	}

	public boolean deleteUser(int userId) {
		boolean flag = false;
		SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		Transaction trasaction = session.beginTransaction();
		UserProfile admin = (UserProfile) session.get(UserProfile.class, userId);
		session.delete(admin);
		trasaction.commit();
		admin = (UserProfile) session.get(UserProfile.class, userId);
		if (admin == null) {
			flag = true;
		}
		return flag;
	}

	public boolean activateUser(int hospitalId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean inactivateUser(int hospitalId) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<UserProfile> searchHospital(String hospitalName, String address1, String email, long phone,
			boolean status) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserProfile getUserById(int userId) {
		SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		// Transaction transaction = session.beginTransaction();
		UserProfile admin = (UserProfile) session.get(UserProfile.class, userId);
		session.close();
		System.out.println(admin.toString());
		return admin;
	}

	public List<UserProfile> getUserByName(String hospitalName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UserProfile> getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UserProfile> getAllHospitalsByPaging(int currPage, int noOfRecPage) {
		// TODO Auto-generated method stub
		return null;
	}

}
