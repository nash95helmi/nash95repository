package com.EmployeeProject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empmst")
public class Employee implements Serializable {

	private static final long serialVersionUID = 6156436951076291032L;

	@Id
	@Column(name = "empid")
	private String id;
	
	@Column(name = "emfnam")
	private String empFName;
	
	@Column(name = "emlnam")
	private String empLName;
	
	@Column(name = "empoid")
	private String empPosId;
	
	@Column(name = "emdept")
	private String empDept;
	
	@Column(name = "emtype")
	private String empType;
	
	@Column(name = "emmngr")
	private String empManager;
	
	@Column(name = "ememel	")
	private String empEmel;
	
	public Employee() {	}

	public Employee(String id, String empFName, String empLName, String empPosId, String empDept, String empType,
			String empManager, String empEmel) {
		this.id = id;
		this.empFName = empFName;
		this.empLName = empLName;
		this.empPosId = empPosId;
		this.empDept = empDept;
		this.empType = empType;
		this.empManager = empManager;
		this.empEmel = empEmel;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmpFName() {
		return empFName;
	}

	public void setEmpFName(String empFName) {
		this.empFName = empFName;
	}

	public String getEmpLName() {
		return empLName;
	}

	public void setEmpLName(String empLName) {
		this.empLName = empLName;
	}

	public String getEmpPosId() {
		return empPosId;
	}

	public void setEmpPosId(String empPosId) {
		this.empPosId = empPosId;
	}

	public String getEmpDept() {
		return empDept;
	}

	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}

	public String getEmpType() {
		return empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	public String getEmpManager() {
		return empManager;
	}

	public void setEmpManager(String empManager) {
		this.empManager = empManager;
	}

	public String getEmpEmel() {
		return empEmel;
	}

	public void setEmpEmel(String empEmel) {
		this.empEmel = empEmel;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empFName=" + empFName + ", empLName=" + empLName + ", empPosId=" + empPosId
				+ ", empDept=" + empDept + ", empType=" + empType + ", empManager=" + empManager + ", empEmel="
				+ empEmel + "]";
	}
}
