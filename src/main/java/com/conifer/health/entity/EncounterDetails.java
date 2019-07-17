package com.conifer.health.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "ENCOUNTER_DETAILS")
public class EncounterDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "ENCOUNTER_DETAILS_ID")
	private long encounterDetailsID;
	@Column(name = "CPT_CODES")
	private String cptCodes;
	@Temporal(TemporalType.DATE)
	@Column(name = "DISCHARGE_DATE")
	private Date dischargeDate;
	@Temporal(TemporalType.DATE)
	@Column(name = "READMISSION_DATE")
	private Date readmissionDate;
	@Temporal(TemporalType.DATE)
	@Column(name = "ADMISSION_DATE")
	private Date admissionDate;
	@OneToOne
	@PrimaryKeyJoinColumn
	private Patient patient;

	public EncounterDetails() {
		
	}

	public EncounterDetails(String cptCodes,
			Date dischargeDate, Date readmissionDate, Date admissionDate) {
		
		this.cptCodes = cptCodes;
		this.dischargeDate = dischargeDate;
		this.readmissionDate = readmissionDate;
		this.admissionDate = admissionDate;

	}


	public long getEncounterDetailsID() {
		return encounterDetailsID;
	}

	public void setEncounterDetailsID(long encounterDetailsID) {
		this.encounterDetailsID = encounterDetailsID;
	}
	
	public String getCptCodes() {
		return cptCodes;
	}

	public void setCptCodes(String cptCodes) {
		this.cptCodes = cptCodes;
	}
	
	public Date getDischargeDate() {
		return dischargeDate;
	}

	public void setDischargeDate(Date dischargeDate) {
		this.dischargeDate = dischargeDate;
	}

	
	public Date getReadmissionDate() {
		return readmissionDate;
	}

	public void setReadmissionDate(Date readmissionDate) {
		this.readmissionDate = readmissionDate;
	}

	
	public Date getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}

	
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
