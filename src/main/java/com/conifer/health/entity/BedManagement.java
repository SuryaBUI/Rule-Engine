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
@Table(name = "BED_MANAGEMENT")
public class BedManagement implements Serializable{
	@Id
	@GeneratedValue
	@Column(name = "BED_ID")
	private long bedID;
	@Column(name = "NUMBER_OF_BEDS")
	private long numberOfBeds;
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Provider provider;

	public BedManagement() {
	}

	public BedManagement(long numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}
	
	public long getBedID() {
		return bedID;
	}

	public void setBedID(long bedID) {
		this.bedID = bedID;
	}
	
	public long getNumberOfBeds() {
		return numberOfBeds;
	}

	public void setNumberOfBeds(long numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}
}
