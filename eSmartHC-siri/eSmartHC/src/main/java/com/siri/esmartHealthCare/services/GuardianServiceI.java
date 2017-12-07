/**
 * 
 */
package com.siri.esmartHealthCare.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.siri.esmartHealthCare.beans.GuardianBean;

/**
 * @author VENU
 *
 */
@Service
public interface GuardianServiceI {
	public GuardianBean addGuardian(GuardianBean gurdBean);
	public GuardianBean updateGuardian(GuardianBean gurdBean);
	public Boolean deleteGuardian(GuardianBean gurdBean);
	public GuardianBean getGuardianByName(String gname);
	public GuardianBean getGuardianById(int gid);
	public List<GuardianBean> getAllGuardians();
	public List<GuardianBean> searchAllGuardian(int id,String name);

}
