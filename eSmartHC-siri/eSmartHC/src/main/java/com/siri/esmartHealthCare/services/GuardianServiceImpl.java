/**
 * 
 */
package com.siri.esmartHealthCare.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siri.esmartHealthCare.beans.GuardianBean;
import com.siri.esmartHealthCare.dao.GuardianDaoI;
import com.siri.esmartHealthCare.domain.Guardian;

/**
 * @author VENU
 *
 */
@Service
public class GuardianServiceImpl implements GuardianServiceI {

	@Autowired
	private GuardianDaoI gurdDao;
	
	public GuardianBean addGuardian(GuardianBean gurdBean) {
		Guardian gurdDomine=mapBeanToDomine(gurdBean);
		gurdDomine=gurdDao.addGuardian(gurdDomine);
		if(gurdDomine.getGid()>0){
			System.out.println("gurdian saved successfully");
		}
		return null;
	}
	
	public GuardianBean mapDomineToBean(Guardian gurdDomine){
		//if(gurdDomine==null)new
		GuardianBean gurdBean=new GuardianBean();
		gurdBean.setName(gurdDomine.getName());
		gurdBean.setDateofbirth(gurdDomine.getDateofbirth());
		gurdBean.setGender(gurdDomine.getGender());
		gurdBean.setMobile(gurdDomine.getMobile());
		gurdBean.setEmail(gurdDomine.getEmail());
		
		return gurdBean;
		
	}

	public Guardian mapBeanToDomine(GuardianBean gurdBean) {
		Guardian gud=new Guardian();
		gud.setName(gurdBean.getName());
		gud.setGender(gurdBean.getGender());
		
		return gud;
	}

	public GuardianBean updateGuardian(GuardianBean gurdBean) {
		Guardian guardian1=mapBeanToDomine(gurdBean);
		Guardian guardian=gurdDao.updateGuardian(guardian1);
		GuardianBean gbean=mapDomineToBean(guardian);
		return gbean;
	}

	public Boolean deleteGuardian(GuardianBean gurdBean) {
		Guardian guardian1=mapBeanToDomine(gurdBean);
		gurdDao.deleteGuardian(guardian1);
		return null;
	}

	public GuardianBean getGuardianByName(String gname) {
		Guardian guardian=gurdDao.getGuardianByName(gname);
		GuardianBean gbean=mapDomineToBean(guardian);
		return gbean;
	}

	public GuardianBean getGuardianById(int gid) {
		Guardian guardian=gurdDao.getGuardianById(gid);
		GuardianBean gbean=mapDomineToBean(guardian);
		return gbean;
	}

	public List<GuardianBean> getAllGuardians() {
	List<Guardian> gurdlist=gurdDao.getAllGuardians();
	List<GuardianBean> gbeanlist=mapDomainToBean(gurdlist);
		return gbeanlist;
	}
	
	
	public GuardianBean mapDomainToBean(Guardian guardian){
		GuardianBean gbean=new GuardianBean();
		gbean.setName(guardian.getName());
		gbean.setDateofbirth(guardian.getDateofbirth());
		gbean.setGender(guardian.getGender());
		gbean.setMobile(guardian.getMobile());
		gbean.setEmail(guardian.getEmail());
		return gbean;
	}

	private List<GuardianBean> mapDomainToBean(List<Guardian> gurdlist) {
		List<GuardianBean> gbeanlist=new ArrayList<GuardianBean>();
		for(Guardian guardian:gurdlist){
			GuardianBean gbean=new GuardianBean();
			gbean.setName(guardian.getName());
			gbean.setDateofbirth(guardian.getDateofbirth());
			gbean.setGender(guardian.getGender());
			gbean.setMobile(guardian.getMobile());
			gbean.setEmail(guardian.getEmail());
			gbeanlist.add(gbean);
		}
		return gbeanlist;
	}

	public List<GuardianBean> searchAllGuardian(int id, String name) {
	List<Guardian> glist=gurdDao.searchAllGuardian(id, name);
	List<GuardianBean> gbeanlist=new ArrayList<GuardianBean>();
	for(Guardian gd:glist){
		GuardianBean gbean=mapDomainToBean(gd);
		gbeanlist.add(gbean);
		
	}
		return gbeanlist;
	}
	

}
