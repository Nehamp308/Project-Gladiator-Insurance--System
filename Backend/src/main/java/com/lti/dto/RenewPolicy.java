package com.lti.dto;

public class RenewPolicy {

	private String registrationNo;
	private int PolicyId;
	private int duration;
	private String plan;
	private double idv;
	private double premium;
	
	public String getRegistrationNo() {
		return registrationNo;
	}
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}
	public int getPolicyId() {
		return PolicyId;
	}
	public void setPolicyId(int policyId) {
		PolicyId = policyId;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
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
