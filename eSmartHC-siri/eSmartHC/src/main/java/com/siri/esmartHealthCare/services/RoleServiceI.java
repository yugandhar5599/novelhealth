package com.siri.esmartHealthCare.services;

import java.util.List;

import com.siri.esmartHealthCare.beans.RoleBean;

public interface RoleServiceI {
	public RoleBean getRoleByName(String roleName);
	public List<String> getRoleByNames(String roleName);
	
}
