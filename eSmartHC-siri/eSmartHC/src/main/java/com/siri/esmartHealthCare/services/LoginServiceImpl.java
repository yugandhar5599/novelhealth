package com.siri.esmartHealthCare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siri.esmartHealthCare.dao.LoginDaoI;

@Service
public class LoginServiceImpl implements LoginServiceI{

	@Autowired
	private LoginDaoI loginDao;
	
	@Override
	public String getRoleNameByUserId(String userName) {
		String roleName = loginDao.getRoleNameByUserId(userName);
		return roleName;
	}

}
