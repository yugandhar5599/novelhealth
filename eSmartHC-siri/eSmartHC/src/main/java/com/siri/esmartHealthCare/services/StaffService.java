/**
 * 
 */
package com.siri.esmartHealthCare.services;

import java.util.List;

import com.siri.esmartHealthCare.beans.DoctorBean;
import com.siri.esmartHealthCare.beans.StaffBean;

/**
 * @author VENU
 *
 */
public interface StaffService {
	public StaffBean addStaff(StaffBean staffBean);
	public StaffBean updateStaff(StaffBean staffBean);
	public Boolean deleteStaff(StaffBean staffBean);
	public Boolean deleteStaff(int staffId);
	public StaffBean getStaffById(int staffId);
	public StaffBean getStaffByName(String name);
	public List<StaffBean> getAllStaffs();
	public List<StaffBean> searchAllStaffs(int staffId,String name);
}
