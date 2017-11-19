package com.dotridge.service;

import java.util.List;

import com.dotridge.bean.UserProfileBean;
import com.dotridge.domain.UserProfile;

public interface UserService {
	public UserProfileBean addUser(UserProfileBean userProfileBean);

	public UserProfileBean updateUser(UserProfileBean userProfileBean);

	public boolean deleteUser(int userId);

	public boolean activateUser(int hospitalId);

	public boolean inactivateUser(int hospitalId);

	public List<UserProfileBean> getAllUsers();

	public List<UserProfile> searchHospital(String hospitalName, String address1, String email, long phone,
			boolean status);

	public UserProfileBean getUserById(int userId);

	public List<UserProfile> getUserByName(String hospitalName);

	public List<UserProfile> getUserByEmail(String email);

	public List<UserProfile> getAllHospitalsByPaging(int currPage, int noOfRecPage);
}
