/**
 * 
 */
package com.siri.esmartHealthCare.beans;

import java.io.Serializable;

/**
 * @author VENU
 *
 */
public class UserRoleBean implements Serializable {

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4988684012458242074L;

	private int roleId;
	
	private String roleName;
}
