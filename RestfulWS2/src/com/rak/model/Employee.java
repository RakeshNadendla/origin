package com.rak.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMP_RAK")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EID")
	private int eid;
	@Column(name = "ENAME")
	private String ename;
	@Column(name = "ESALARY")
	private String esalary;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEsalary() {
		return esalary;
	}

	public void setEsalary(String esalary) {
		this.esalary = esalary;
	}

	public Employee() {
		super();
	}

	public Employee(int eid, String ename, String esalary) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.esalary = esalary;
	}

}
