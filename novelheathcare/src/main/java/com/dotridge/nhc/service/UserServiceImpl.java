package com.dotridge.nhc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotridge.nhc.persistence.dao.UserDao;
import com.dotridge.nhc.persistence.entity.User;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao loginDao;

	public User getUserByName(String name) {
		 User user = loginDao.getUserByName(name);
		 return user;
	}

}
