package com.conifer.health.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ruletable")
public class RuleEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String assignedToUser;
	private Date date;
	private String days;
	private String description;
	private String name;
	private String ruletype;
	private Date time;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAssignedToUser() {
		return assignedToUser;
	}
	public void setAssignedToUser(String assignedToUser) {
		this.assignedToUser = assignedToUser;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRuletype() {
		return ruletype;
	}
	public void setRuletype(String ruletype) {
		this.ruletype = ruletype;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
}
