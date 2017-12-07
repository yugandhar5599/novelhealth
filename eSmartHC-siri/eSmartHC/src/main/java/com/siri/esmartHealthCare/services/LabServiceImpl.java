/**
 * 
 */
package com.siri.esmartHealthCare.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.siri.esmartHealthCare.beans.GuardianBean;
import com.siri.esmartHealthCare.beans.LabBean;
import com.siri.esmartHealthCare.dao.LabDao;
import com.siri.esmartHealthCare.domain.Guardian;
import com.siri.esmartHealthCare.domain.Lab;

/**
 * @author VENU
 *
 */
@Service
public class LabServiceImpl implements LabService{
	@Autowired
	private LabDao labDao;

	@Override
	public LabBean addLab(LabBean labBean) {
		Lab lab=mapBeanToDomine(labBean);
		lab=labDao.addLab(lab);
		if(lab.getLabId()>0){
			System.out.println("lab saved successfully");
		}
		return null;
	}

	private Lab mapBeanToDomine(LabBean labBean) {
		Lab lab=new Lab();
		lab.setLabId(labBean.getLabId());
		lab.setLabName(labBean.getLabName());
		lab.setEmail(labBean.getEmail());
		lab.setMobileno(labBean.getMobileno());
		return lab;
	}

	@Override
	@Transactional
	public LabBean updateLab(LabBean labBean) {
		Lab lab=mapBeanToDomine(labBean);
		Lab lab1=labDao.updateLab(lab);
		LabBean lbean=mapDomineToBean(lab1);
		return lbean;
	}

	private LabBean mapDomineToBean(Lab lab1) {
		LabBean lbean=new LabBean();
		lbean.setLabId(lab1.getLabId());
		lbean.setLabName(lab1.getLabName());
		lbean.setEmail(lab1.getEmail());
		lbean.setMobileno(lab1.getMobileno());
		return lbean;
	}

	@Override
	@Transactional
	public Boolean deleteLab(LabBean labBean) {
		Lab lab=mapBeanToDomine(labBean);
		labDao.deleteLab(lab);
		return true;
	}

	@Override
	public LabBean getLabByName(String labName) {
		Lab lab=labDao.getLabByName(labName);
		LabBean lbean=mapDomineToBean(lab);
		return lbean;
	}

	@Override
	public LabBean getLabById(int labId) {
		Lab lab=labDao.getLabById(labId);
		LabBean lbean=mapDomineToBean(lab);
		return lbean;
	}

	@Override
	public List<LabBean> getAllLabs() {
		List<Lab> labList=labDao.getAllLabs();
		List<LabBean> labBeanList=new ArrayList<LabBean>();
		for(Lab lab:labList){
			LabBean lbean=mapDomineToBean(lab);
			labBeanList.add(lbean);	
		}
			return labBeanList;
	}

	@Override
	public List<LabBean> searchAllLab(int labId, String labName) {
		List<Lab> labList=labDao.searchAllLab(labId, labName);
		List<LabBean> lBeanList=new ArrayList<LabBean>();
		for(Lab lab:labList){
			LabBean lbean=mapDomineToBean(lab);
			lBeanList.add(lbean);
			
		}
			return lBeanList;
	}

	@Override
	@Transactional
	public Boolean deleteLab(int labId) {
		labDao.deleteLab(labId);
		return null;
	}

}
