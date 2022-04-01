package com.lti.dto;

import java.time.LocalDate;

public class PolicyDto {

	private int id;
	private String registrationNo;
	//private int vehicleId;
	private String policyType;
	private LocalDate startDate;
	private LocalDate endDate;
	private double idv;
	private double premium;
	
	public PolicyDto(int id,String policyType, LocalDate startDate, LocalDate endDate , double idv, double premium, String registrationNo) {
		super();
		this.id=id;
		this.policyType=policyType;
		this.startDate=startDate;
		this.endDate= endDate;
		this.idv=idv;
		this.premium=premium;
		this.registrationNo=registrationNo;
		//this.vehicleId=vehicleId;
		
		
	}
	
	public PolicyDto() {
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRegistrationNo() {
		return registrationNo;
	}
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}
	

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public double getIdv() {
		return idv;
	}

	public void setIdv(double idv) {
		this.idv = idv;
	}

	public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}
	
	
	
	
}
