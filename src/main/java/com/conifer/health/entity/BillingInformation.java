package com.conifer.health.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "BILLING_INFORMATION")
public class BillingInformation implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "BILL_ID")
	private long billingInformationID;
	@Column(name = "DAILY_CHARGE_AMOUNT")
	private int dailyChargeAmount;
	@OneToOne
	@PrimaryKeyJoinColumn
	private Patient patient;
	
	public BillingInformation() {
	}
	public BillingInformation(int dailyChargeAmount) {
		
		this.dailyChargeAmount = dailyChargeAmount;
		
	}

	public long getBillingInformationID() {
		return billingInformationID;
	}
	public void setBillingInformationID(long billingInformationID) {
		this.billingInformationID = billingInformationID;
	}
	
	public int getDailyChargeAmount() {
		return dailyChargeAmount;
	}
	public void setDailyChargeAmount(int dailyChargeAmount) {
		this.dailyChargeAmount = dailyChargeAmount;
	}
	
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}
