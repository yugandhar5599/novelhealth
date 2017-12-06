package com.dotridge.dao;

import com.dotridge.domain.UserProfile;

public interface RegistrationDao 
{
	public UserProfile createUser(UserProfile user);
}
