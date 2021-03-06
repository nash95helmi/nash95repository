package com.reportsManager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mngmst")
public class Manager implements Serializable{

	private static final long serialVersionUID = 453084109374892841L;
	
	/**
	 * Column for id/key in database must start with "id", default naming for id property in Spring
	 * else the id property will not found during compiling
	 */
	@Id
	@Column(name = "mngrid")
	private String id;
	
	@Column(name = "mnfnam")
	private String managerFName;
	
	@Column(name = "mnlnam")
	private String managerLName;
	
	@Column(name = "mnpoid")
	private String managerPos;
	
	@Column(name = "mndept")
	private String managerDept;
	
	@Column(name = "mnasts")
	private String managerSta;
	
	public Manager() {
		
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getManagerFName() {
		return managerFName;
	}
	
	public void setManagerFName(String managerFName) {
		this.managerFName = managerFName;
	}
	
	public String getManagerLName() {
		return managerLName;
	}
	
	public void setManagerLName(String managerLName) {
		this.managerLName = managerLName;
	}
	
	public String getManagerPos() {
		return managerPos;
	}
	
	public void setManagerPos(String managerPos) {
		this.managerPos = managerPos;
	}
	
	public String getManagerDept() {
		return managerDept;
	}
	
	public void setManagerDept(String managerDept) {
		this.managerDept = managerDept;
	}
	
	public String getManagerSta() {
		return managerSta;
	}
	
	public void setManagerSta(String managerSta) {
		this.managerSta = managerSta;
	}
}
