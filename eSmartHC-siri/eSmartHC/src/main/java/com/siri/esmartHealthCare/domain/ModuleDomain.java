/**
 * 
 */
package com.siri.esmartHealthCare.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author VENU
 *
 */
@Entity
public class ModuleDomain {
	
	@Id
	@GeneratedValue
	private int moduleId;
	private String moduleName;
	/*
	@OneToMany(mappedBy="userPer")
	private List<UserPermissions> userPer;*/
	
	public int getModuleId() {
		return moduleId;
	}
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	

}
