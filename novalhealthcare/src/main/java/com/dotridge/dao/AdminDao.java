package com.dotridge.dao;

import java.util.List;

import com.dotridge.domain.Admin;

public interface AdminDao {

	public Admin addAdmin(Admin admin);

	public boolean deleteAdmin(int adminId);

	public boolean activateAdmin(int adminId);

	public boolean inactivateAdmin(int adminId);

	public List<Admin> getAllAdmins();

	public List<Admin> searchAdmin(String firstName, String lastName, String email, long phone, boolean status);

	public Admin getAdminById(int adminId);

}
