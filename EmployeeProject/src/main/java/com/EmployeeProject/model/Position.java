package com.EmployeeProject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "posmst")
public class Position implements Serializable{

	private static final long serialVersionUID = -2168192216587353456L;
	
	@Id
	@Column(name = "posid")
	private String id;
	
	@Column(name = "postle")
	private String posTitle;
	
	@Column(name = "possal")
	private Integer posSalary;
	
	@Column(name = "posgrp")
	private String posGroup;
	
	public Position() {
		
	}
	
	public Position(String id, String posTitle, Integer posSalary, String posGroup) {
		this.id = id;
		this.posTitle = posTitle;
		this.posSalary = posSalary;
		this.posGroup = posGroup;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPosTitle() {
		return posTitle;
	}

	public void setPosTitle(String posTitle) {
		this.posTitle = posTitle;
	}

	public Integer getPosSalary() {
		return posSalary;
	}

	public void setPosSalary(Integer posSalary) {
		this.posSalary = posSalary;
	}

	public String getPosGroup() {
		return posGroup;
	}

	public void setPosGroup(String posGroup) {
		this.posGroup = posGroup;
	}
}
