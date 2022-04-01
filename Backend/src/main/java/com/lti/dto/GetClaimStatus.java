package com.lti.dto;

public class GetClaimStatus {

	private int claimId;
	private String claimReason;
	private String ClaimStatus;
	private double amount;
	
	
	public int getClaimId() {
		return claimId;
	}
	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}
	public String getClaimReason() {
		return claimReason;
	}
	public void setClaimReason(String claimReason) {
		this.claimReason = claimReason;
	}
	public String getClaimStatus() {
		return ClaimStatus;
	}
	public void setClaimStatus(String claimStatus) {
		ClaimStatus = claimStatus;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
