/**
 * 
 */
package com.siri.esmartHealthCare.dao;

import java.util.List;

import com.siri.esmartHealthCare.domain.Department;

/**
 * @author VENU
 *
 */
public interface DepartmentDaoI {
	public Department addDepartment(Department department);
	public Department updateDepartment(Department department);
	public Boolean deleteDepartment(Department department);
	public Department getDepartmentByName(String deptName);
	public Department getDepartmentById(int deptId);
	public List<Department> getAllDepartments();
	public List<Department> searchAllDepartments(int id,String name);

}
