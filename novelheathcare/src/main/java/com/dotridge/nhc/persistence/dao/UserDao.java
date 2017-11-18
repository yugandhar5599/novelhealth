package com.dotridge.nhc.persistence.dao;

import com.dotridge.nhc.persistence.entity.User;

public interface UserDao {
	public User getUserByName(String name);
}
