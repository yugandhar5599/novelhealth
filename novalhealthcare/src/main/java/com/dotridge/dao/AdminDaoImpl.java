package com.dotridge.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.dotridge.domain.Admin;
import com.dotridge.domain.Hospital;
import com.dotridge.domain.UserProfile;
import com.dotridge.util.SessionFactoryUtil;
@Repository
public class AdminDaoImpl implements AdminDao {

	public Admin addAdmin(Admin admin) {
		SessionFactory sessionFactory=SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		Transaction trasaction =session.beginTransaction();
		session.save(admin);
		trasaction.commit();
		session.close();
		return admin;

	}

	public boolean deleteAdmin(int adminId) {
		boolean flag = false;
		SessionFactory sessionFactory=SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		Admin admin =(Admin)session.get(Admin.class, adminId);
		session.delete(admin); 
		admin =(Admin)session.get(Admin.class, adminId);
		if(admin==null){
			flag=true;
		}
		return flag;
	}

	public boolean activateAdmin(int adminId) {
			SessionFactory sessionFactory=SessionFactoryUtil.getInstance();
			Session session = sessionFactory.openSession();
			Admin admin =(Admin)session.load(Admin.class, adminId);
			admin.setStatus(true);
			session.update(admin);
			session.close();
			return admin.isStatus();
	}

	public boolean inactivateAdmin(int adminId) {
		SessionFactory sessionFactory=SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		Admin admin =(Admin)session.load(Admin.class, adminId);
		admin.setStatus(false);
		session.update(admin);
		session.close();
		return admin.isStatus();
	}

	public List<Admin> getAllAdmins() {
		SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from admin");
		List<Admin> listofadmins = query.list();

		session.close();
		System.out.println("list of users are" + listofadmins.size());
		return listofadmins;
	}

	public List<Admin> searchAdmin(String firstName, String lastName, String email, long phone, boolean status) {
		// TODO Auto-generated method stub
		return null;
	}

	public Admin getAdminById(int adminId) {
		// TODO Auto-generated method stub
		return null;
	}

}
