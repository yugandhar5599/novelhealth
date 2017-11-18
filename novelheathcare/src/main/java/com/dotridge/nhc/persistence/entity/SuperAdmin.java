package com.dotridge.nhc.persistence.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
@Entity
@Table(name="super_admin_table")
@PrimaryKeyJoinColumn(name="id")
public class SuperAdmin extends User implements Serializable {
	private static final long serialVersionUID = 8087415086798211485L;

}
