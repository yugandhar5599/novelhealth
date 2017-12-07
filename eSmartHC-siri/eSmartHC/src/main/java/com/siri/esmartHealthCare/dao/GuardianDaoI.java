/**
 * 
 */
package com.siri.esmartHealthCare.dao;

import java.util.List;

import com.siri.esmartHealthCare.domain.Guardian;

/**
 * @author VENU
 *
 */
public interface GuardianDaoI {
	public Guardian addGuardian(Guardian guardian);
	public Guardian updateGuardian(Guardian guardian);
	public Boolean deleteGuardian(Guardian guardian);
	public Guardian getGuardianByName(String gname);
	public Guardian getGuardianById(int gid);
	public List<Guardian> getAllGuardians();
	public List<Guardian> searchAllGuardian(int id,String name);

}
