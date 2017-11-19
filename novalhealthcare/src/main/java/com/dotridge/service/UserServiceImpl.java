package com.dotridge.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotridge.bean.HospitalBean;
import com.dotridge.bean.UserProfileBean;
import com.dotridge.dao.HospitalDao;
import com.dotridge.dao.UserDao;
import com.dotridge.domain.Hospital;
import com.dotridge.domain.UserProfile;

@Service()
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Autowired
	private HospitalDao hospitalDao;

	public UserProfileBean addUser(UserProfileBean userProfileBean) {
		UserProfile admin = mapBeanToDomain(userProfileBean);
		String hospitalName = userProfileBean.getHospitalName();
		Hospital hospital = hospitalDao.getHospitalNames(hospitalName);
		admin.setHospital(hospital);
		admin = userDao.addUser(admin);
		userProfileBean = mapDomainToBean(admin);
		return userProfileBean;
	}

	public UserProfileBean updateUser(UserProfileBean userProfileBean) {
		UserProfile userProfile = userDao.updateUser(mapBeanToDomain(userProfileBean));
		return mapDomainToBean(userProfile);
	}

	public boolean deleteUser(int userId) {
		userDao.deleteUser(userId);
		return false;
	}

	public boolean activateUser(int hospitalId) {
		return false;
	}

	public boolean inactivateUser(int hospitalId) {
		return false;
	}

	public List<UserProfileBean> getAllUsers() {
		System.out.println("enter into services");
		List<UserProfile> userslist = userDao.getAllUsers();

		System.out.println("list of users are" + userslist.size());
		List<UserProfileBean> uiuserslist = null;

		if (userslist != null && !userslist.isEmpty()) {
			System.out.println("if  execution successfully");
			uiuserslist = new ArrayList<UserProfileBean>();
			for (UserProfile userProfile : userslist) {
				UserProfileBean userProfileBean = mapDomainToBean(userProfile);
				uiuserslist.add(userProfileBean);
			}
			System.out.println(uiuserslist.size());
			return uiuserslist;
		} else {
			// System.out.println("else block executed");
			// throw new RuntimeException("No Hosp are available");

		}
		return uiuserslist;
	}

	public List<UserProfile> searchHospital(String hospitalName, String address1, String email, long phone,
			boolean status) {
		return null;
	}

	public UserProfileBean getUserById(int userId) {
		return mapDomainToBean(userDao.getUserById(userId));
	}

	public List<UserProfile> getUserByName(String hospitalName) {
		return null;
	}

	public List<UserProfile> getUserByEmail(String email) {
		return null;
	}

	public List<UserProfile> getAllHospitalsByPaging(int currPage, int noOfRecPage) {
		return null;
	}

	public UserProfile mapBeanToDomain(UserProfileBean userProfileBean) {

		UserProfile userProfile = new UserProfile();
		System.out.println("mapping method reached");
			userProfile.setAdminId(userProfileBean.getAdminId());
		
		userProfile.setFirstName(userProfileBean.getFirstName());
		userProfile.setMiddleName(userProfileBean.getMiddleName());
		userProfile.setLastName(userProfileBean.getLastName());
		userProfile.setEmail(userProfileBean.getEmail());
		userProfile.setPassword(userProfileBean.getPassword());
		userProfile.setPhone(userProfileBean.getPhone());
		userProfile.setStatus(userProfileBean.isStatus());
		return userProfile;
	}

	public UserProfileBean mapDomainToBean(UserProfile userProfile) {
		UserProfileBean userProfileBean = new UserProfileBean();
		userProfileBean.setAdminId(userProfile.getAdminId());
		userProfileBean.setFirstName(userProfile.getFirstName());
		userProfileBean.setMiddleName(userProfile.getMiddleName());
		userProfileBean.setLastName(userProfile.getLastName());
		userProfileBean.setEmail(userProfile.getEmail());
		userProfileBean.setPassword(userProfile.getPassword());
		userProfileBean.setPhone(userProfile.getPhone());
		userProfileBean.setStatus(userProfile.isStatus());
		return userProfileBean;
	}

}
