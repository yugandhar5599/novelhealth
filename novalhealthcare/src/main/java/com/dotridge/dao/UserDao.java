package com.dotridge.dao;

import java.util.List;

import com.dotridge.domain.Hospital;
import com.dotridge.domain.UserProfile;

public interface UserDao {
	public UserProfile addUser(UserProfile userProfile);

	public UserProfile updateUser(UserProfile userProfile);

	public boolean deleteUser(int userId);

	public boolean activateUser(int hospitalId);

	public boolean inactivateUser(int hospitalId);

	public List<UserProfile> getAllUsers();

	public List<UserProfile> searchHospital(String hospitalName, String address1, String email, long phone,
			boolean status);

	public UserProfile getUserById(int userId);

	public List<UserProfile> getUserByName(String hospitalName);

	public List<UserProfile> getUserByEmail(String email);

	public List<UserProfile> getAllHospitalsByPaging(int currPage, int noOfRecPage);

}
