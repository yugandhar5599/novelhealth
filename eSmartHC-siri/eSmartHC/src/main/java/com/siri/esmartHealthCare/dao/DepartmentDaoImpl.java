/**
 * 
 */
package com.siri.esmartHealthCare.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.siri.esmartHealthCare.domain.Department;

/**
 * @author VENU
 *
 */
@Repository
public class DepartmentDaoImpl implements DepartmentDaoI {
	@Autowired
	private SessionFactory sf;
	/* (non-Javadoc)
	 * @see com.siri.espc.dao.DepartmentDaoI#addDepartment(com.siri.espc.domains.Department)
	 */
	public Department addDepartment(Department department) {
		Session hsession=sf.openSession();
		hsession.save(department);
		hsession.close();
		return department;
	}

	/* (non-Javadoc)
	 * @see com.siri.espc.dao.DepartmentDaoI#updateDepartment(com.siri.espc.domains.Department)
	 */
	public Department updateDepartment(Department department) {
		Session hsession=sf.openSession();
		Transaction tx = hsession.beginTransaction();
		hsession.update(department);
		//tx.commit();
		//hsession.close();
		return department;
	}

	/* (non-Javadoc)
	 * @see com.siri.espc.dao.DepartmentDaoI#deleteDepartment(com.siri.espc.domains.Department)
	 */
	public Boolean deleteDepartment(Department department) {
		Session hsession=sf.openSession();
		Transaction txn=hsession.beginTransaction();
		System.out.println(department.getDeptName());
		hsession.delete(department);
		txn.commit();
		//hsession.close();
		return null;

	}

	/* (non-Javadoc)
	 * @see com.siri.espc.dao.DepartmentDaoI#getDepartmentByName(java.lang.String)
	 */
	public Department getDepartmentByName(String deptName) {
		Session hsession=sf.openSession();
		Criteria criteria=hsession.createCriteria(Department.class).add(Restrictions.eq("deptName", deptName));
		Department department=(Department) criteria.uniqueResult();
		hsession.close();
		return department;
	}

	/* (non-Javadoc)
	 * @see com.siri.espc.dao.DepartmentDaoI#getDepartmentById(int)
	 */
	public Department getDepartmentById(int deptId) {
		Session hsession=sf.openSession();
		Department department=(Department) hsession.get(Department.class, deptId);
		//hsession.close();
		return department;
	}

	/* (non-Javadoc)
	 * @see com.siri.espc.dao.DepartmentDaoI#getAllDepartments()
	 */
	public List<Department> getAllDepartments() {
		Session hsession=sf.openSession();
		Criteria criteria=hsession.createCriteria(Department.class);
		List<Department> deptlist=criteria.list();
		hsession.close();
		return deptlist;
	}

	public List<Department> searchAllDepartments(int id, String name) {
		Session hsession=sf.openSession();
		Query query=hsession.createQuery("from Department where deptId=? or deptName=?");
		query.setParameter(0, id);
		query.setParameter(1, name);
		List<Department> deptlist=query.list();
		return deptlist;
	}

}
