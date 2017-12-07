/**
 * 
 */
package com.siri.esmartHealthCare.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author VENU
 *
 */
@Entity
public class Tests implements Serializable {
	@Id
	@GeneratedValue
	private int tid;
	private String tname;
	@Temporal(TemporalType.DATE)
	private Date tdate;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Date getTdate() {
		return tdate;
	}
	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}
	

}
