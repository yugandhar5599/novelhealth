/**
 * 
 */
package com.siri.esmartHealthCare.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.siri.esmartHealthCare.domain.Doctor;
import com.siri.esmartHealthCare.domain.Staff;

/**
 * @author VENU
 *
 */
@Repository
public class StaffDaoImpl implements StaffDao{
	@Autowired
	private SessionFactory sf;

	@Override
	public Staff addStaff(Staff staff) {
		Session ses = sf.openSession();
		ses.save(staff);
		ses.close();
		return staff;
	}

	@Override
	public Staff updateStaff(Staff staff) {
		Session ses = sf.getCurrentSession();
		System.out.println("dao"+staff.getStaffId());
		ses.update(staff);
		//ses.beginTransaction().commit();
		return staff;
	}

	@Override
	public Boolean deleteStaff(Staff staff) {
		Session ses = sf.openSession();
		ses.delete(staff);
		ses.beginTransaction().commit();
		return true;
	}

	@Override
	public Staff getStaffByName(String name) {
		Session hsession = sf.openSession();
		System.out.println("is session created::"+hsession.isOpen());
		Criteria criteria=hsession.createCriteria(Staff.class).
				add(Restrictions.eq("name",name));
		System.out.println(criteria.list().size());
		Staff staff=(Staff) criteria.uniqueResult();
		return staff;
	}

	@Override
	public Staff getStaffById(int staffId) {
		Session ses = sf.openSession();
		Staff staff=(Staff) ses.get(Staff.class, staffId);
		return staff;
	}

	@Override
	public List<Staff> getAllStaffs() {
		Session ses=sf.openSession();
		Criteria ct=ses.createCriteria(Staff.class);
		List<Staff> stafflist=ct.list();
		return stafflist;
	}

	@Override
	public List<Staff> searchAllStaffs(int staffId, String name) {
		Session hsession=sf.openSession();
		Query query=hsession.createQuery("from Staff where staffId=? or name=? ");
		query.setParameter(0, staffId);
		query.setParameter(1, name);
		List<Staff> stafflist=query.list();
		
		return stafflist;
	}

	@Override
	public Boolean deleteStaff(int staffId) {
		Session session=sf.getCurrentSession();
		Criteria criteria=session.createCriteria(Staff.class).add(Restrictions.eq("staffId", staffId));
		Staff staff=(Staff) criteria.uniqueResult();
		session.delete(staff);
		return null;
	}
	

}
