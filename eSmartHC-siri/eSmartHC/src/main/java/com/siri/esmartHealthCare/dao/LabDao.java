/**
 * 
 */
package com.siri.esmartHealthCare.dao;

import java.util.List;

import com.siri.esmartHealthCare.domain.Lab;

/**
 * @author VENU
 *
 */
public interface LabDao {
	public Lab addLab(Lab lab);
	public Lab updateLab(Lab lab);
	public Boolean deleteLab(Lab lab);
	public Boolean deleteLab(int labId);
	public Lab getLabByName(String labName);
	public Lab getLabById(int labId);
	public List<Lab> getAllLabs();
	public List<Lab> searchAllLab(int labId,String labName);
}
