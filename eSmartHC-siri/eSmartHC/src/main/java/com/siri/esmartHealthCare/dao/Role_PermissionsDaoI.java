/**
 * 
 */
package com.siri.esmartHealthCare.dao;

import java.util.ArrayList;

import com.siri.esmartHealthCare.domain.Guardian;
import com.siri.esmartHealthCare.domain.Role_Permissions;
import com.siri.esmartHealthCare.domain.UserPermissions;

/**
 * @author VENU
 *
 */
public interface Role_PermissionsDaoI {
	public void addRole_Permissions();
	public void updateRole_Permissions();
	public void deleteRole_Permissions();
	public Role_Permissions getRole_Permissions();
	public Role_Permissions getRole_PermissionsByName();
	public ArrayList<Role_Permissions> getAllRole_Permissions();
	public Role_Permissions searchAllUserPermissions(int rpid);

}
