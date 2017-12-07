/**
 * 
 */
package com.siri.esmartHealthCare.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author VENU
 *
 */
@Entity
public class Department implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4454437338452220910L;
	
	@Id
	@GeneratedValue
	private int deptId;
	private String deptName;
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	

}
