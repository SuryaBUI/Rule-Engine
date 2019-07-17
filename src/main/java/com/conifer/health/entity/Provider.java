package com.conifer.health.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PROVIDER")
public class Provider implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name = "PROVIDER_ID")
	private long providerId;
	@Column(name = "START_DATE")
	private Date startDate;
	@Column(name = "END_DATE")
	private Date endDate;
	@OneToOne(mappedBy = "provider",cascade = CascadeType.ALL)
	private BedManagement bedManagement;
	@OneToOne(mappedBy = "provider",cascade = CascadeType.ALL)
	private BillingInfo billingInfo;
	
	
	public Provider() {

	}

	public Provider(Date startDate, Date endDate, BedManagement bedManagement,BillingInfo billingInfo) {

		this.startDate = startDate;
		this.endDate = endDate;
		this.bedManagement = bedManagement;
		this.billingInfo = billingInfo;
	}

	
	public long getProviderId() {
		return providerId;
	}

	public void setProviderId(long providerId) {
		this.providerId = providerId;
	}
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public BedManagement getBedManagement() {
		return bedManagement;
	}

	public void setBedManagement(BedManagement bedManagement) {
		this.bedManagement = bedManagement;
	}
	
	public BillingInfo getBillingInfo() {
		return billingInfo;
	}

	public void setBillingInfo(BillingInfo billingInfo) {
		this.billingInfo = billingInfo;
	}

}
