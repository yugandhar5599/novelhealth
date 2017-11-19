package com.dotridge.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dotridge.beans.NurseBean;
import com.dotridge.dao.NurseDao;
import com.dotridge.domain.Nurse;

public class NurseServiceImpl implements NurseServive {
	@Autowired
	private NurseDao nurseDao;

	@Override
	public Nurse mapBeanToDomain(NurseBean nurseBean) {
		Nurse nurse = new Nurse();
		nurse.setNurseId(nurseBean.getNurseId());
		nurse.setFirstName(nurseBean.getFirstName());
		nurse.setMiddleName(nurseBean.getMiddleName());
		nurse.setLastName(nurseBean.getLastName());
		nurse.setEmail(nurseBean.getEmail());
		nurse.setPhone(nurseBean.getPhone());
		nurse.setPassword(nurseBean.getPassword());
		return nurse;
	}

	@Override
	public NurseBean mapDomainToBean(Nurse nurseDomain) {
		// TODO Auto-generated method stub
		NurseBean nurseBean = new NurseBean();
		nurseBean.setNurseId(nurseDomain.getNurseId());
		nurseBean.setFirstName(nurseDomain.getFirstName());
		nurseBean.setMiddleName(nurseDomain.getMiddleName());
		nurseBean.setLastName(nurseDomain.getLastName());
		nurseBean.setPhone(nurseDomain.getPhone());
		nurseBean.setEmail(nurseDomain.getEmail());
		nurseBean.setPassword(nurseDomain.getPassword());
		return nurseBean;
	}

	@Override
	public NurseBean createNurse(NurseBean nurseBean) {

		Nurse nurseDomain = mapBeanToDomain(nurseBean);
		NurseBean nursBean = mapDomainToBean(nurseDao.createNurse(nurseDomain));
		return nursBean;
	}

	@Override
	public NurseBean updateNurse(int id) {

		NurseBean nurseBean = mapDomainToBean(nurseDao.updateNurse(id));

		return nurseBean;
	}

	@Override
	public NurseBean getNurseById(int id) {

		NurseBean nurseBean = mapDomainToBean(nurseDao.getNurseById(id));
		return nurseBean;
	}

	@Override
	public List<NurseBean> getNurseName(String firstName) {
		List<Nurse> nurseByName = nurseDao.getNurseName(firstName);
		List<NurseBean> nurseBeanList = null;
		if (nurseByName != null && !nurseByName.isEmpty()) {
			for (Nurse nurse : nurseByName) {
				NurseBean NurseBean = mapDomainToBean(nurse);
				nurseBeanList.add(NurseBean);
			}
		}
		return nurseBeanList;
	}

	@Override
	public List<NurseBean> getAllNurses() {
		List<Nurse> allNurses = nurseDao.getAllNurses();
		List<NurseBean> nurseBeanList = null;
		if (allNurses != null && !allNurses.isEmpty()) {
			nurseBeanList=new ArrayList<NurseBean>();
			for (Nurse nurseDomain : allNurses) {
				NurseBean NurseBean = mapDomainToBean(nurseDomain);
				nurseBeanList.add(NurseBean);

			}
			return nurseBeanList;
		}else
			throw new RuntimeException("No Nurse Available");
		
	}

	@Override
	public boolean deleteNurse(int id) {
		// TODO Auto-generated method stub
		return nurseDao.deleteNurse(id);
	}

	@Override
	public List<NurseBean> getAllAdminsByPagining(int currentPage,
			int numberOfRecords) {
		// TODO Auto-generated method stub
		return null;
	}

}
