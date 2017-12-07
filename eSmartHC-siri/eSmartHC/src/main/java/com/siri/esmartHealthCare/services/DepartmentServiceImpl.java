/**
 * 
 */
package com.siri.esmartHealthCare.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siri.esmartHealthCare.beans.DepartmentBean;
import com.siri.esmartHealthCare.dao.DepartmentDaoI;
import com.siri.esmartHealthCare.domain.Department;

/**
 * @author VENU
 *
 */
@Service
public class DepartmentServiceImpl implements DepartmentServiceI {
	@Autowired
	private DepartmentDaoI deptDao;

	public DepartmentBean addDepartment(DepartmentBean deptbean) {
		Department department=mapBeanToDomain(deptbean);
		deptDao.addDepartment(department);
		return null;
	}

	private Department mapBeanToDomain(DepartmentBean deptbean) {
		Department department=new Department();
		department.setDeptName(deptbean.getDeptName());
		return department;
	}

	public DepartmentBean updateDepartment(DepartmentBean beptbean) {
		Department department=mapBeanToDomain(beptbean);
		Department dept=deptDao.updateDepartment(department);
		DepartmentBean deptbean=mapDomainToBean(dept);
		return deptbean;
	}

	public Boolean deleteDepartment(DepartmentBean beptbean) {
		Department department=mapBeanToDomain(beptbean);
		deptDao.deleteDepartment(department);
		
		return null;
	}

	public DepartmentBean getDepartmentByName(String dname) {
		Department department=deptDao.getDepartmentByName(dname);
		DepartmentBean deptbean=mapDomainToBean(department);
		return deptbean;
	}

	private DepartmentBean mapDomainToBean(Department department) {
		DepartmentBean deptbean=new DepartmentBean();
		deptbean.setDeptName(department.getDeptName());
		return deptbean;
	}

	public DepartmentBean getDepartmentById(int deptid) {
		Department department=deptDao.getDepartmentById(deptid);
		DepartmentBean deptbean=mapDomainToBean(department);
		return deptbean;
	}

	public List<DepartmentBean> getAllDepartments() {
		List<Department> deptlist=deptDao.getAllDepartments();
		List<DepartmentBean> deptbeanlist=mapDomainToBean(deptlist);
		return deptbeanlist;
	}

	private List<DepartmentBean> mapDomainToBean(List<Department> deptlist) {
		List<DepartmentBean> deptbeanlist=new ArrayList<DepartmentBean>();
		for(Department dept:deptlist){
			DepartmentBean deptbean=new DepartmentBean();
			deptbean.setDeptName(dept.getDeptName());	
			deptbeanlist.add(deptbean);
		}
		return deptbeanlist;
	}

	public List<DepartmentBean> searchAllDepartments(int id, String name) {
		List<Department> deptlist=deptDao.searchAllDepartments(id, name);
		List<DepartmentBean> deptbeanlist=new ArrayList<DepartmentBean>();
		for(Department dept:deptlist){
			DepartmentBean deptbean=mapDomainToBean(dept);
			deptbeanlist.add(deptbean);
			
		}
		return deptbeanlist;
	}
	
	
	

}
