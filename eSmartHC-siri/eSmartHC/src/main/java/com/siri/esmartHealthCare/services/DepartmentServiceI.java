/**
 * 
 */
package com.siri.esmartHealthCare.services;

import java.util.List;

import com.siri.esmartHealthCare.beans.DepartmentBean;

/**
 * @author VENU
 *
 */
public interface DepartmentServiceI {
	public DepartmentBean addDepartment(DepartmentBean beptbean);
	public DepartmentBean updateDepartment(DepartmentBean beptbean);
	public Boolean deleteDepartment(DepartmentBean beptbean);
	public DepartmentBean getDepartmentByName(String dname);
	public DepartmentBean getDepartmentById(int deptid);
	public List<DepartmentBean> getAllDepartments();
	public List<DepartmentBean> searchAllDepartments(int id,String name);
}
