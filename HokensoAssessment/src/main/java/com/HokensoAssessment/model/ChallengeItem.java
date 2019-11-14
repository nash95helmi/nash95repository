package com.HokensoAssessment.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "challengemaster")
public class ChallengeItem implements Serializable{

	private static final long serialVersionUID = -3286176956290877489L;
	
	@Id
	@Column(name = "challengeid")
	private String id;
	
	@Column(name = "challengetitle")
	private String title;
	
	@Column(name = "challengelevel")
	private String level;
	
	@Column(name = "challengecalories")
	private Integer calories;
	
	@Column(name = "challengepoints")
	private Integer points;
	
	@Column(name = "challengetype")
	private String type;

	public ChallengeItem() {}

	public ChallengeItem(String id, String title, String level, Integer calories, Integer points, String type) {
		this.id = id;
		this.title = title;
		this.level = level;
		this.calories = calories;
		this.points = points;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Integer getCalories() {
		return calories;
	}

	public void setCalories(Integer calories) {
		this.calories = calories;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ChallengeItem [id=" + id + ", title=" + title + ", level=" + level + ", calories=" + calories
				+ ", points=" + points + ", type=" + type + "]";
	}
}
