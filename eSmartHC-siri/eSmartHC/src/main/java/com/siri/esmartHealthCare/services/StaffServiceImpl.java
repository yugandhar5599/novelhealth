/**
 * 
 */
package com.siri.esmartHealthCare.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.siri.esmartHealthCare.beans.StaffBean;
import com.siri.esmartHealthCare.dao.StaffDao;
import com.siri.esmartHealthCare.domain.Staff;

/**
 * @author VENU
 *
 */
@Service
public class StaffServiceImpl implements StaffService {
	@Autowired	
	private StaffDao dao;
	

	@Override
	public StaffBean addStaff(StaffBean staffBean) {
		Staff staff = mapBeanToDomain(staffBean);
		staff = dao.addStaff(staff);
		if(staff.getStaffId() > 0){
			System.out.println("staff saved successfully");
		}
		return null;

	}

	private Staff mapBeanToDomain(StaffBean staffBean) {
		Staff staff=new Staff();
		staff.setStaffId(staffBean.getStaffId());
		staff.setName(staffBean.getName());
		staff.setEmail(staffBean.getEmail());
		staff.setGender(staffBean.getGender());
		staff.setMobileno(staffBean.getMobileno());
		return staff;
	}

	@Override
	@Transactional
	public StaffBean updateStaff(StaffBean staffBean) {
		System.out.println("service"+staffBean.getStaffId());
		Staff staff = mapBeanToDomain(staffBean);
		System.out.println("service2"+staff.getStaffId());
		Staff staff1=dao.updateStaff(staff);
		StaffBean sbean=mapDomainToBean(staff1);
		return sbean;
	}

	private StaffBean mapDomainToBean(Staff staff1) {
		StaffBean staffBean=new StaffBean();
		staffBean.setStaffId(staff1.getStaffId());
		staffBean.setName(staff1.getName());
		staffBean.setEmail(staff1.getEmail());
		staffBean.setGender(staff1.getGender());
		staffBean.setMobileno(staff1.getMobileno());
		return staffBean;
	}

	@Override
	@Transactional
	public Boolean deleteStaff(StaffBean staffBean) {
		Staff staff = mapBeanToDomain(staffBean);
		dao.deleteStaff(staff);
		return true;	}

	@Override
	public StaffBean getStaffById(int staffId) {
		Staff staff=dao.getStaffById(staffId);
		StaffBean sbean=mapDomainToBean(staff);
		return sbean;
	}

	@Override
	public StaffBean getStaffByName(String name) {
		Staff staff=dao.getStaffByName(name);
		StaffBean sbean=mapDomainToBean(staff);
		return sbean;
	}

	@Override
	public List<StaffBean> getAllStaffs() {
		List<Staff> slist=dao.getAllStaffs();
		List<StaffBean> sbeanlist=new ArrayList<StaffBean>();
		for(Staff staff:slist){
			StaffBean sbean=mapDomainToBean(staff);
			sbeanlist.add(sbean);
			
		}
	return sbeanlist;
	}

	@Override
	public List<StaffBean> searchAllStaffs(int staffId, String name) {
		List<Staff> slist=dao.getAllStaffs();
		List<StaffBean> sbeanlist=new ArrayList<StaffBean>();
		for(Staff staff:slist){
			StaffBean sbean=mapDomainToBean(staff);
			sbeanlist.add(sbean);
			
		}
	return sbeanlist;	
	}

	@Override
	@Transactional
	public Boolean deleteStaff(int staffId) {
		dao.deleteStaff(staffId);
		return null;
	}

}
