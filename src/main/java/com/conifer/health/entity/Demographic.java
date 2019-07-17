package com.conifer.health.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "DEMOGRAPHIC") 
public class Demographic implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "DEMOID")
	private long demoID;
	@Column(name = "DOB")
	private Date dob;
	//private long age;
	
	@OneToOne
	@PrimaryKeyJoinColumn 
	private Patient patient;

	public Demographic() {
		
	}

	public Demographic(Date dob) {
		
		this.dob = dob;
		}


	
	public long getDemoID() {
		return demoID;
	}

	public void setDemoID(long demoID) {
		this.demoID = demoID;
	}

	
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		
		this.dob = dob;
		LocalDate birthday = dob.toInstant().atZone(ZoneId.systemDefault())
				.toLocalDate();
		LocalDate now = LocalDate.now();
		Period p = Period.between(birthday, now);
		long age = p.getYears();
	}

    public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
