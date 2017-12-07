/**
 * 
 */
package com.siri.esmartHealthCare.services;

import java.util.List;

import com.siri.esmartHealthCare.beans.LabBean;

/**
 * @author VENU
 *
 */
public interface LabService {
	public LabBean addLab(LabBean labBean);
	public LabBean updateLab(LabBean labBean);
	public Boolean deleteLab(LabBean labBean);
	public Boolean deleteLab(int labId);
	public LabBean getLabByName(String labName);
	public LabBean getLabById(int labId);
	public List<LabBean> getAllLabs();
	public List<LabBean> searchAllLab(int labId,String labName);

}
