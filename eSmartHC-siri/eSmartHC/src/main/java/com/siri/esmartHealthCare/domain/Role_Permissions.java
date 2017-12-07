/**
 * 
 */
package com.siri.esmartHealthCare.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author VENU
 *
 */
@Entity
public class Role_Permissions implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2928221158811914559L;

	@Id
	@GeneratedValue
	private int rpId;
	
	@ManyToOne
	private UserPermissions userper;
	
	@ManyToOne
	private UserRoles userrole;

	public int getRpId() {
		return rpId;
	}

	public void setRpId(int rpId) {
		this.rpId = rpId;
	}

	public UserPermissions getUserper() {
		return userper;
	}

	public void setUserper(UserPermissions userper) {
		this.userper = userper;
	}

	public UserRoles getUserrole() {
		return userrole;
	}

	public void setUserrole(UserRoles userrole) {
		this.userrole = userrole;
	}

}
