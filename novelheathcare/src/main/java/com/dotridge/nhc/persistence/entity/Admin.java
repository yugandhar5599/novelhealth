package com.dotridge.nhc.persistence.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "admin_table")
@PrimaryKeyJoinColumn(name = "id")
public class Admin extends User implements Serializable {
	private static final long serialVersionUID = 1717091120072211794L;

}
