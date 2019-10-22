package org.ManagerProject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "deptmst")
public class Department implements Serializable{

	private static final long serialVersionUID = -7727256222151578070L;
	
	@Id
	@Column(name = "deptid")
	private String id;
	
	@Column(name = "deptmt")
	private String department;
	
	@Column(name = "dectlo")
	private String controlOffice;
	
	@Column(name = "deadd1")
	private String address1;
	
	@Column(name = "deadd2")
	private String address2;
	
	public Department() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getControlOffice() {
		return controlOffice;
	}

	public void setControlOffice(String controlOffice) {
		this.controlOffice = controlOffice;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}
}
