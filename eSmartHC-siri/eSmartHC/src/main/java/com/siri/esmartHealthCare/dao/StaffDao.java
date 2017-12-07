/**
 * 
 */
package com.siri.esmartHealthCare.dao;

import java.util.List;

import com.siri.esmartHealthCare.domain.Staff;

/**
 * @author VENU
 *
 */
public interface StaffDao {
	public Staff addStaff(Staff staff);
	public Staff updateStaff(Staff staff);
	public Boolean deleteStaff(Staff staff);
	public Boolean deleteStaff(int staffId);
	public Staff getStaffByName(String name);
	public Staff getStaffById(int staffId);
	public List<Staff> getAllStaffs();
	public List<Staff> searchAllStaffs(int staffId,String name);

}
