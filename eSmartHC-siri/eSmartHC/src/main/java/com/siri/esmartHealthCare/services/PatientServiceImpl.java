/**
 * 
 */
package com.siri.esmartHealthCare.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siri.esmartHealthCare.beans.PatientBean;
import com.siri.esmartHealthCare.dao.PatientDaoI;
import com.siri.esmartHealthCare.dao.RoleDaoI;
import com.siri.esmartHealthCare.domain.Patient;
import com.siri.esmartHealthCare.domain.RoleDomaine;

/**
 * @author VENU
 *
 */
@Service
public class PatientServiceImpl implements PatientServiceI {
	
     @Autowired(required=true)
	private PatientDaoI patientDao;
     @Autowired
     private RoleDaoI rdao;
	
	public PatientBean addPatient(PatientBean ptBean) {
		Patient ptDomain = mapBeanToDomain(ptBean);
		ptDomain = patientDao.addPatient(ptDomain);
		if(ptDomain.getPid() > 0){
			System.out.println("patient saved successfully");
		}
	
		return null;
	}
		public Patient mapBeanToDomain(PatientBean ptBean){
		Patient pt = new Patient();
		pt.setMobile(ptBean.getMobile());
		pt.setEmail(ptBean.getEmail());
		pt.setGender(ptBean.getGender());
		pt.setPname(ptBean.getPname());
		String rolename=ptBean.getRole();
		RoleDomaine role=rdao.getRoleByName(rolename);
		pt.setRole(role);
		return pt; 
	}
		
		
	public PatientBean updatePatient(PatientBean ptbean) {
		Patient patient=mapBeanToDomain(ptbean);
		Patient pt=patientDao.updatePatient(patient);
		PatientBean pbean=mapDomainToBean(pt);
		return pbean;
	}
	public Boolean deletePatient(PatientBean ptbean) {
		Patient patient=mapBeanToDomain(ptbean);
		patientDao.deletePatient(patient);
		return null;
	}
	public PatientBean getPatientByName(String pname) {
		Patient patient=patientDao.getPatientByName(pname);
		PatientBean pbean=mapDomainToBean(patient);
		return pbean;
	}
	public PatientBean mapDomainToBean(Patient pt){  
		PatientBean ptBean = new PatientBean();
		ptBean.setPname(pt.getPname());
		//ptBean.setDateofbirth(pt.getDateofbirth());
		ptBean.setGender(pt.getGender());
		ptBean.setEmail(pt.getEmail());
		return ptBean;
	}

	public PatientBean getPatientById(int pid) {
		Patient patient=patientDao.getPatientById(pid);
		PatientBean pbean=mapDomainToBean(patient);
		return pbean;
	}
	public List<PatientBean> getAllPatient() {
	List<Patient> plist=patientDao.getAllPatients();
	List<PatientBean> pbeanlist=mapDomainToBean(plist);
		return pbeanlist;
	}
	private List<PatientBean> mapDomainToBean(List<Patient> plist) {
		List<PatientBean> pbeanlist=new ArrayList<PatientBean>();
		if(pbeanlist != null && pbeanlist.size() >0){
			for(Patient patient:plist){
				PatientBean pbean=new PatientBean();
				pbean.setPname(patient.getPname());
				//pbean.setDateofbirth(patient.getDateofbirth());
				pbean.setGender(patient.getGender());
				pbean.setEmail(patient.getEmail());
				pbean.setPid(patient.getPid());
				pbeanlist.add(pbean);
				
			}
		}
		
		
		return pbeanlist;
	}
	public List<PatientBean> searchAllPatients(int id, String name) {
		List<Patient> plist=patientDao.searchAllPatients(id, name);
		List<PatientBean> pbeanlist=new ArrayList<PatientBean>();
		for(Patient patient:plist){
			PatientBean pbean=mapDomainToBean(patient);
			pbeanlist.add(pbean);	
		}
		return pbeanlist;
	}


}
