package com.dotridge.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotridge.bean.HospitalBean;
import com.dotridge.dao.HospitalDao;
import com.dotridge.domain.Hospital;

@Service()
public class HospitalServiceImpl implements HospitalService {
	@Autowired
	private HospitalDao hospitalDao;

	public HospitalBean addHospital(HospitalBean hostpitalBean) {

		Hospital hospitalDomain = hospitalDao.addHospital(mapBeanToDomain(hostpitalBean));

		return mapDomainToBean(hospitalDomain);
	}

	public boolean deleteHospital(int hospitalId) {
		hospitalDao.deleteHospital(hospitalId);
		return false;
	}

	public boolean activateHospital(int hospitalId) {
		return false;
	}

	public boolean inactivateHospital(int hospitalId) {
		return false;
	}

	public List<HospitalBean> getAllHospital() {
		List<Hospital> hosplist = hospitalDao.getAllHospital();
		System.out.println("list of hospitals are" + hosplist.size());
		List<HospitalBean> uihosplist = null;

		if (hosplist != null && !hosplist.isEmpty()) {
			System.out.println("if  execution successfully");
			uihosplist = new ArrayList<HospitalBean>();
			for (Hospital hospitalDomain : hosplist) {
				HospitalBean hospBean = mapDomainToBean(hospitalDomain);
				uihosplist.add(hospBean);
			}
			System.out.println(uihosplist.size());
			return uihosplist;
		} else {
			//throw new RuntimeException("No Hosp are available");

		}
		return uihosplist;
	}

	public List<HospitalBean> searchHospital(String hospitalName, String address1, String email, long phone,
			boolean status) {
		return null;
	}

	public HospitalBean getHospitalById(int hospitalId) {

		return mapDomainToBean(hospitalDao.getHospitalById(hospitalId));
	}

	public Hospital mapBeanToDomain(HospitalBean hospitalBean) {
		Date date = new Date();

		Hospital hospital = new Hospital();

		if (hospitalBean.getHospitalId() > 0) {

			hospital.setId(hospitalBean.getHospitalId());
		}

		hospital.setHospitalName(hospitalBean.getHospitalName());
		hospital.setAddress1(hospitalBean.getAddress1());
		hospital.setAddress2(hospitalBean.getAddress2());
		hospital.setCity(hospitalBean.getCity());
		hospital.setState(hospitalBean.getState());
		// hospital.setZipCode(hospitalBean.getZipCode());
		hospital.setEmail(hospitalBean.getEmail());
		// hospital.setPhone(hospitalBean.getPhone());
		hospital.setFax(hospitalBean.getFax());

		hospital.setPhone(hospitalBean.getPhone());
		hospital.setStatus(hospitalBean.isStatus());

		// hospital.setLogo(hospitalBean.getLogo());
		// hospital.setRegistrationDocument(hospitalBean.getRegistrationDocument());
		// hospital.setStatus(hospitalBean.getStatus());
		hospital.setCreatedBy("Yugandhar");
		hospital.setCreatedDate(date);
		hospital.setModifiedBy("Yugandhar");
		hospital.setModifiedDate(date);
		return hospital;
	}

	public HospitalBean mapDomainToBean(Hospital hospitalDomain) {
		HospitalBean hospitalBean = new HospitalBean();

		hospitalBean.setHospitalId(hospitalDomain.getId());
		hospitalBean.setHospitalName(hospitalDomain.getHospitalName());
		hospitalBean.setAddress1(hospitalDomain.getAddress1());
		hospitalBean.setAddress2(hospitalDomain.getAddress2());
		hospitalBean.setCity(hospitalDomain.getCity());
		hospitalBean.setState(hospitalDomain.getState());

		hospitalBean.setPhone(hospitalDomain.getPhone());
		hospitalBean.setStatus(hospitalDomain.isStatus());

		// hospitalBean.setZipCode(hospitalDomain.getZipCode());
		hospitalBean.setEmail(hospitalDomain.getEmail());
		// hospitalBean.setPhone(hospitalDomain.getPhone());
		hospitalBean.setFax(hospitalDomain.getFax());
		// hospitalBean.setLogo(hospitalDomain.getLogo());
		// hospitalBean.setRegistrationDocument(hospitalDomain.getRegistrationDocument());
		// hospitalBean.setStatus(hospitalDomain.getStatus());
		return hospitalBean;
	}

	public HospitalBean updateHospital(HospitalBean hospitalBean) {

		Hospital hospitalDomain = hospitalDao.updateHospital(mapBeanToDomain(hospitalBean));

		return mapDomainToBean(hospitalDomain);
	}

	public List<HospitalBean> getHospitalByName(String hospitalName) {
		List<Hospital> hosplist = hospitalDao.getHospitalByName(hospitalName);
		List<HospitalBean> uihosplist = null;

		if (hosplist != null && !hosplist.isEmpty()) {
			System.out.println("if  execution successfully");
			uihosplist = new ArrayList<HospitalBean>();
			for (Hospital hospitalDomain : hosplist) {
				HospitalBean hospBean = mapDomainToBean(hospitalDomain);
				uihosplist.add(hospBean);
			}
			System.out.println(uihosplist.size());
			return uihosplist;
		} else {
			// System.out.println("else block executed");
			throw new RuntimeException("No Hosp are available");
		}
	}

	public List<HospitalBean> getHospitalByEmail(String email) {
		List<Hospital> hosplist = hospitalDao.getHospitalByEmail(email);
		List<HospitalBean> uihosplist = null;

		if (hosplist != null && !hosplist.isEmpty()) {
			System.out.println("if  execution successfully");
			uihosplist = new ArrayList<HospitalBean>();
			for (Hospital hospitalDomain : hosplist) {
				HospitalBean hospBean = mapDomainToBean(hospitalDomain);
				uihosplist.add(hospBean);
			}
			System.out.println(uihosplist.size());
			return uihosplist;
		} else {
			// System.out.println("else block executed");
			throw new RuntimeException("No Hosp are available");
		}
	}

	public List<HospitalBean> getAllHospitalsByPaging(int currPage, int noOfRecPage) {
		List<Hospital> hospDomainList = hospitalDao.getAllHospitalsByPaging(currPage, noOfRecPage);
		List<HospitalBean> hospBeanList = null;
		if (hospDomainList != null && !hospDomainList.isEmpty()) {
			hospBeanList = new ArrayList<HospitalBean>();
			for (Hospital hosp : hospDomainList) {
				hospBeanList.add(mapDomainToBean(hosp));
			}
		}

		return hospBeanList;
	}
	/*
	 * public static void main(String[] args) {
	 * 
	 * List<Hospital> hosplist = hospitalDao.getAllHospital();
	 * System.out.println("list of hospitals are" + hosplist.size()); }
	 */
}
