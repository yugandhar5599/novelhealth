package com.siri.esmartHealthCare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.siri.esmartHealthCare.beans.RoleBean;
import com.siri.esmartHealthCare.dao.RoleDaoI;
import com.siri.esmartHealthCare.domain.RoleDomaine;
@Service
public class RoleServicempl implements RoleServiceI{

	@Autowired
	private RoleDaoI roleDao;
	

	private RoleBean mapDomaineToBean(RoleDomaine roleDomaine) {
		RoleBean roleBean = new RoleBean();
		roleBean.setRoleId(roleDomaine.getRoleId());
		roleBean.setRoleName(roleDomaine.getRoleName());
		return roleBean;
	}
	
	
		public RoleBean getRoleByName(String roleName){
			RoleDomaine roleDomaine = roleDao.getRoleByName(roleName);
			RoleBean roleBean = mapDomaineToBean(roleDomaine);
			return roleBean;
		}


		@Override
		public List<String> getRoleByNames(String roleName) {
			List<String> roleNames=roleDao.getRoleByNames(roleName);
			return roleNames;
		}




	
}
