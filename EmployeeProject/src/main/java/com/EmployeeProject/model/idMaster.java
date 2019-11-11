package com.EmployeeProject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "idmaster")
public class idMaster implements Serializable{

	private static final long serialVersionUID = 2516446979509249104L;
	
	@Id
	@Column(name = "groupid")
	private String id;
	
	@Column(name = "currentid")
	private String currentId;
	
	public idMaster() {
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCurrentId() {
		return currentId;
	}
	public void setCurrentId(String currentId) {
		this.currentId = currentId;
	}
	
	
}
