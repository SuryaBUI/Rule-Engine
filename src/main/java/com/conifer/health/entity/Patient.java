package com.conifer.health.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PATIENT")
public class Patient implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;
	@Column(name = "RECORD_DATE")
	private Date recordDate;
	@OneToOne(mappedBy = "patient",cascade = CascadeType.ALL)
	private Demographic demographic;
	@OneToOne(mappedBy = "patient",cascade = CascadeType.ALL)
	private EncounterDetails encounter;
	@OneToOne(mappedBy = "patient",cascade = CascadeType.ALL)
	private Claims claims;
	@OneToOne(mappedBy = "patient",cascade = CascadeType.ALL)
	private BillingInformation billingInformation;

	public Patient() {

	}

	public Patient(Date recordDate) {
		this.recordDate = recordDate;
		
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}


	public Demographic getDemographic() {
		return demographic;
	}

	public void setDemographic(Demographic demographic) {
		this.demographic = demographic;
	}
	public EncounterDetails getEncounter() {
		return encounter;
	}

	public void setEncounter(EncounterDetails encounter) {
		this.encounter = encounter;
	}
	public Claims getClaims() {
		return claims;
	}

	public void setClaims(Claims claims) {
		this.claims = claims;
	}
	
	public BillingInformation getBillingInformation() {
		return billingInformation;
	}

	public void setBillingInformation(BillingInformation billingInformation) {
		this.billingInformation = billingInformation;
	}

}
