package com.dotridge.nhc.persistence.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.dotridge.nhc.persistence.entity.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public User getUserByName(String name) {
		SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
		Query query = sessionFactory.openSession().createQuery("from User where userName=:userName");
		query.setParameter("userName", name);
		User user = (User) query.uniqueResult();
		return user;

	}

}
