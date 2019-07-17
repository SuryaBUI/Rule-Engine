package com.conifer.health.entity;

import java.io.Serializable;
import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "CLAIMS")
public class Claims implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "CLAIM_ID")
	private long cliamID;
	@Column(name = "CLAIM_STATUS")
	private String claimstatus;
	/*@Column(name = "REVENUE_CODE")
	private HashMap<String, String> revenueCodeServiceUnitsMap;*/
	@Column(name = "REVENUE_CODE")
	private String revenueCodeServiceUnitsMap;
	@OneToOne
	@PrimaryKeyJoinColumn 
	private Patient patient;

	public Claims() {
	}

	public Claims(String claimstatus,
			 String revenueCodeServiceUnitsMap) {

		this.claimstatus = claimstatus;
		this.revenueCodeServiceUnitsMap = revenueCodeServiceUnitsMap;

	}

	public long getCliamID() {
		return cliamID;
	}

	public void setCliamID(long cliamID) {
		this.cliamID = cliamID;
	}

	
	public String getClaimstatus() {
		return claimstatus;
	}

	public void setClaimstatus(String claimstatus) {
		this.claimstatus = claimstatus;
	}

	/*@ElementCollection
	@MapKeyColumn(name = "mapKey")
	@Column(name = "mapValue")*/

	public String getRevenueCodeServiceUnitsMap() {
		return revenueCodeServiceUnitsMap;
	}

	public void setRevenueCodeServiceUnitsMap(
			String revenueCodeServiceUnitsMap) {
		this.revenueCodeServiceUnitsMap = revenueCodeServiceUnitsMap;
	}


	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}
