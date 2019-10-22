package com.reportsManager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "posmst")
public class Position implements Serializable{

	private static final long serialVersionUID = 8061773546237644005L;

	@Id
	@Column(name = "posid")
	private String id;
	
	@Column(name = "postle")
	private String posTitle;
	
	@Column(name = "possal")
	private Integer posSalary;
	
	public Position() {
		
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
}
