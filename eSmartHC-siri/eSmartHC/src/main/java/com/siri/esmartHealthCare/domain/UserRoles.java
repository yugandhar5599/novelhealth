/**
 * 
 */
package com.siri.esmartHealthCare.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author VENU
 *
 */
@Entity
@Table(name = "role")
public class UserRoles implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int roleId;
	
	private String roleName;
	
	/*//@ManyToMany
	private SignupDomain signndomain;*/
	
	@OneToMany(mappedBy="userper",cascade=CascadeType.ALL)
	private List<Role_Permissions> userPermissions;

	
	public List<Role_Permissions> getUserPermissions() {
		return userPermissions;
	}

	public void setUserPermissions(List<Role_Permissions> userPermissions) {
		this.userPermissions = userPermissions;
	}

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

}
