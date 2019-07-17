package com.conifer.health.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "BILLING_INFO")
public class BillingInfo implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name = "BILL_ID")
	private long billingInfoID;
	@Column(name = "ACCOUNT_RECEIVABLE_AMOUNT")
	private int accountReceivableAmount;
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Provider provider;
	
	public BillingInfo() {
	}
	public BillingInfo(int accountReceivableAmount) {
		
		this.accountReceivableAmount = accountReceivableAmount;
		
	}

	public long getBillingInfoID() {
		return billingInfoID;
	}
	public void setBillingInfoID(long billingInfoID) {
		this.billingInfoID = billingInfoID;
	}
	@Column(name = "ACCOUNT_RECEIVE_AMOUNT")
	public int getAccountReceivableAmount() {
		return accountReceivableAmount;
	}
	public void setAccountReceivableAmount(int accountReceivableAmount) {
		this.accountReceivableAmount = accountReceivableAmount;
	}
	
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	
}
