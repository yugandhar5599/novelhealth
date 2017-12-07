package com.dotridge.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotridge.bean.DoctorBean;
import com.dotridge.dao.DoctorDao;
import com.dotridge.domain.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService
{
	@Autowired
	private DoctorDao doctorDao;
	
	public Doctor mapBeanToDomain(DoctorBean doctorBean) 
	{
		Date date = new Date();
		Doctor doctor = new Doctor();
		doctor.setFirstName(doctorBean.getFirstName());
		doctor.setMiddleName(doctorBean.getMiddleName());
		doctor.setLastName(doctorBean.getLastName());
		doctor.setEmail(doctorBean.getEmail());
		doctor.setPassword(doctorBean.getPassword());
		doctor.setProfilePicture(doctorBean.getProfilePicture());
		doctor.setProfileDocuments(doctorBean.getProfileDocuments());
		doctor.setStatus(doctorBean.isStatus());
		doctor.setCreatedBy("Yugandhar");
		doctor.setCreatedDate(date);
		doctor.setMiddleName("Yugandhar");
		doctor.setModifiedDate(date);
		return doctor;
	}

	public DoctorBean mapDomainToBean(Doctor doctorDomain) 
	{
		DoctorBean doctorBean = new DoctorBean();
		doctorBean.setFirstName(doctorDomain.getFirstName());
		doctorBean.setMiddleName(doctorDomain.getMiddleName());
		doctorBean.setLastName(doctorDomain.getLastName());
		doctorBean.setEmail(doctorDomain.getEmail());
		doctorBean.setPassword(doctorDomain.getPassword());
		doctorBean.setProfileDocuments(doctorDomain.getProfileDocuments());
		doctorBean.setProfilePicture(doctorDomain.getProfileDocuments());
		doctorBean.setStatus(doctorDomain.isStatus());
		return doctorBean;
	}

	public DoctorBean createDoctor(DoctorBean doctorBean) 
	{
		DoctorBean doctorBean2 = mapDomainToBean(doctorDao.createDoctor(mapBeanToDomain(doctorBean)));
		return doctorBean2;
	}

	public DoctorBean updateDoctor(DoctorBean doctorBean) 
	{
		DoctorBean doctorBean2 = mapDomainToBean(doctorDao.updateDoctor(mapBeanToDomain(doctorBean)));
		return doctorBean2;
	}

	public DoctorBean getDoctorById(int id) 
	{
		DoctorBean doctorBean = mapDomainToBean(doctorDao.getDoctorById(id));
		return doctorBean;
	}

	public List<DoctorBean> getDoctorByName(String doctorFirstName) 
	{
		List<Doctor> doctors = doctorDao.getDoctorByName(doctorFirstName);
		List<DoctorBean> doctorBeans = new ArrayList<DoctorBean>();
		for(Doctor doctor : doctors)
		{
			doctorBeans.add(mapDomainToBean(doctor));
		}
		return doctorBeans;
	}

	public List<DoctorBean> getDoctorByEmail(String email) 
	{
		List<Doctor> doctors = doctorDao.getDoctorByEmail(email);
		List<DoctorBean> doctorBeans = new ArrayList<DoctorBean>();
		for(Doctor doctor : doctors)
		{
			doctorBeans.add(mapDomainToBean(doctor));
		}
		return doctorBeans;
	}

	public List<DoctorBean> getDoctorByPhone(long phoneNumber) 
	{
		List<Doctor> doctors = doctorDao.getDoctorByPhone(phoneNumber);
		List<DoctorBean> doctorBeans = new ArrayList<DoctorBean>();
		for(Doctor doctor : doctors)
		{
			doctorBeans.add(mapDomainToBean(doctor));
		}
		return doctorBeans;
	}

	public List<DoctorBean> getDoctorByStatus(Boolean status) 
	{
		List<Doctor> doctors = doctorDao.getDoctorByStatus(status);
		List<DoctorBean> doctorBeans = new ArrayList<DoctorBean>();
		for(Doctor doctor : doctors)
		{
			doctorBeans.add(mapDomainToBean(doctor));
		}
		return doctorBeans;
	}

	public List<DoctorBean> getAllDoctors() 
	{
		List<Doctor> doctors = doctorDao.getAllDoctors();
		List<DoctorBean> doctorBeans = new ArrayList<DoctorBean>();
		for(Doctor doctor : doctors)
		{
			doctorBeans.add(mapDomainToBean(doctor));
		}
		return doctorBeans;
	}

	public boolean deleteDoctor(int id) 
	{
		return doctorDao.deleteDoctor(id);
	}

	public List<DoctorBean> getAllDoctorsByPagining(int currentPage, int numberOfRecords) 
	{
		List<Doctor> doctors = doctorDao.getAllDoctorsByPagining(currentPage, numberOfRecords);
		List<DoctorBean> doctorBeans = new ArrayList<DoctorBean>();
		for(Doctor doctor : doctors)
		{
			doctorBeans.add(mapDomainToBean(doctor));
		}
		return doctorBeans;
	}
}
