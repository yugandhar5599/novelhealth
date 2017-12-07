/**
 * 
 */
package com.siri.esmartHealthCare.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.siri.esmartHealthCare.beans.DoctorBean;
import com.siri.esmartHealthCare.dao.DoctorDaoI;
import com.siri.esmartHealthCare.domain.Doctor;

/**
 * @author VENU
 *
 */

@Service
public class DoctorServiceImpl implements DoctorServiceI {
	
	@Autowired	
	private DoctorDaoI dao;
	
	
	//add doctor method
	public DoctorBean addDoctor(DoctorBean doctBean) {
		Doctor docDomain = mapBeanToDomain(doctBean);
		docDomain = dao.addDoctor(docDomain);
		if(docDomain.getDocId() > 0){
			System.out.println("doctor saved successfully");
		}
		return null;
	}
		public Doctor mapBeanToDomain(DoctorBean docBean){
			if(docBean == null)
				throw new RuntimeException("doctor ionformation not foumd");
		Doctor doc = new Doctor();
		doc.setDateofbirth(docBean.getDateOfBirth());
		doc.setEmail(docBean.getEmail());
		doc.setGender(docBean.getGender());
		doc.setMobileno(docBean.getMobilenumber());
		doc.setName(docBean.getDocName());
		doc.setDocId(docBean.getDocId());
		//doc.setSpecialization(docBean.getSpecialization());
		//System.out.println(docBean.getSpecialization());
		
		return doc; 
	}

	//get doctor by id	
	public DoctorBean getDoctorById(int docId) {
		Doctor doc=dao.getDoctorById(docId);
		DoctorBean dbean=mapDomainToBean(doc);
		return dbean;
	}
	private DoctorBean mapDomainToBean(Doctor doc) {
		DoctorBean dbean=new DoctorBean();
		dbean.setDocName(doc.getName());
		dbean.setEmail(doc.getEmail());
		dbean.setGender(doc.getGender());
		dbean.setDocId(doc.getDocId());
		
		return dbean;
	}

	//get all doctors
	public List<DoctorBean> getAllDoctors() {
	List<Doctor> doc=dao.getAllDoctors();
	List<DoctorBean> dblist=mapDomainToBean(doc);
		return dblist;
	}
	public List<DoctorBean> mapDomainToBean(List<Doctor> doclist){
		List<DoctorBean> docBeanlist = new ArrayList<DoctorBean>();
		for(Doctor db:doclist){
			DoctorBean dbean=new DoctorBean();
			dbean.setDocId(db.getDocId());
			dbean.setDocName(db.getName());
			dbean.setEmail(db.getEmail());
			dbean.setGender(db.getGender());
			docBeanlist.add(dbean);
		}
		return docBeanlist;
	}
	
	//get doctor by name
	public DoctorBean getDoctorByName(String name) {
		Doctor doc=dao.getDoctorByName(name);
		DoctorBean dbean=mapDomainToBean(doc);
		return dbean;
	}
	
	//update doctor
	@Transactional(rollbackFor=Exception.class)
	public void updateDoctor(DoctorBean doctBean) {
		System.out.println("service"+doctBean.getDocId());
		Doctor doctor = mapBeanToDomain(doctBean);
		System.out.println("service2"+doctor.getDocId());
		dao.updateDoctor(doctor);
		//DoctorBean dbean=mapDomainToBean(doc);
		//return dbean;
	}
	@Transactional
	public Boolean deleteDoctor(DoctorBean doctBean) {
		Doctor doctor = mapBeanToDomain(doctBean);
		dao.deleteDoctor(doctor);
		return true;
	}
	public List<DoctorBean> searchAllDoctors(int id, String name) {
	List<Doctor> doclist=dao.searchAllDoctors(id, name);
	List<DoctorBean> docbeanlist=new ArrayList<DoctorBean>();
	for(Doctor doc:doclist){
		DoctorBean dbean=mapDomainToBean(doc);
		docbeanlist.add(dbean);
		
	}
		return docbeanlist;
	}
	@Override
	@Transactional
	public String deleteDoctor(int docId) {
		System.out.println("doctor service is called"+docId);
		String msg=dao.deleteDoctor(docId);
		return msg;
	}	
}
