package com.dotridge.service;

import java.util.List;

import com.dotridge.domain.Admin;

public interface AdminService {

	public Admin addAdmin(Admin admin);

	public boolean deleteAdmin(int adminId);

	public boolean activateAdmin(int adminId);

	public boolean inactivateAdmin(int adminId);

	public List<Admin> getAllAdmins();

	public List<Admin> searchAdmin(String firstName, String lastName, String email, long phone, boolean status);

	public Admin getAdminById(int adminId);
}
