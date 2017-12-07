/**
 * 
 */
package com.siri.esmartHealthCare.beans;

import java.io.Serializable;

/**
 * @author VENU
 *
 */
public class UserPermissionsBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7072545987938910487L;

	private int permissionsId;
	
	private String permissionName;

	public int getPermissionsId() {
		return permissionsId;
	}

	public void setPermissionsId(int permissionsId) {
		this.permissionsId = permissionsId;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	
}
