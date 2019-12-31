package com.poc.aim.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bovine")
public class Bovine {

	private long id;
	private String movedFrom;
	private String movedTo;
	private String thirdParty;
	private String tagNumber;
	private String healthCertNo;
	private String provinceMovementSystem;
	
	public Bovine() {
		
	}
	
	public Bovine(long id, String movedFrom, String movedTo, String thirdParty, String tagNumber, String healthCertNo, String provinceMovementSystem) {
		this.id = id;
		this.movedFrom = movedFrom;
		this.movedTo = movedTo;
		this.thirdParty = thirdParty;
		this.tagNumber = tagNumber;
		this.healthCertNo = healthCertNo;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	@Column(name="movedFrom", nullable=false)
	public String getMovedFrom() {
		return movedFrom;
	}

	public void setMovedFrom(String movedFrom) {
		this.movedFrom = movedFrom;
	}
	@Column(name="movedTo", nullable=false)
	public String getMovedTo() {
		return movedTo;
	}

	public void setMovedTo(String movedTo) {
		this.movedTo = movedTo;
	}
	@Column(name="thirdParty", nullable=false)
	public String getThirdParty() {
		return thirdParty;
	}

	public void setThirdParty(String thirdParty) {
		this.thirdParty = thirdParty;
	}
	@Column(name="tagNumber", nullable=false)
	public String getTagNumber() {
		return tagNumber;
	}

	public void setTagNumber(String tagNumber) {
		this.tagNumber = tagNumber;
	}
	@Column(name="healthCertNo", nullable=false)
	public String getHealthCertNo() {
		return healthCertNo;
	}

	public void setHealthCertNo(String healthCertNo) {
		this.healthCertNo = healthCertNo;
	}
	@Column(name="provinceMovementSystem", nullable=false)
	public String getProvinceMovementSystem() {
		return provinceMovementSystem;
	}

	public void setProvinceMovementSystem(String provinceMovementSystem) {
		this.provinceMovementSystem = provinceMovementSystem;
	}

	@Override
	public String toString() {
		return "Bovine [id=" + id + ", movedFrom=" + movedFrom + ", movedTo=" + movedTo + ", thirdParty=" + thirdParty
				+ ", tagNumber=" + tagNumber +", healthCertNo=" + healthCertNo +", provinceMovementSystem="+ provinceMovementSystem +"]";
	}


}
