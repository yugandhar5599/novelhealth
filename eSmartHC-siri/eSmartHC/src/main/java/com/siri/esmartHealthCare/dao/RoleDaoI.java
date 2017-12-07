package com.siri.esmartHealthCare.dao;

import java.util.List;

import com.siri.esmartHealthCare.domain.RoleDomaine;

public interface RoleDaoI {
	public RoleDomaine getRoleByName(String roleName);
	public RoleDomaine getRoleByName();
	public List<String> getRoleByNames(String roleName);
}
