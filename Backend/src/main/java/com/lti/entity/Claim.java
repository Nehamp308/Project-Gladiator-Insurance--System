package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tbl_claim")
public class Claim {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "claim_seq")
	@SequenceGenerator(sequenceName = "TBL_CLAIM_CLAIM_ID_SEQ", allocationSize = 1, name = "claim_seq")
	@Column(name="claim_id")
	private  int claimId;
	
	@Column(name="claim_date")
	private LocalDate claimDate;
	
	@Column(name="claim_reason")
	private String claimReason;
	
	@Column(name="claim_status")
	private String claimStatus;
	
	@Column(name="claim_amount")
	private double amount;
	
	
	@ManyToOne
	@JoinColumn (name = "user_id")
	private User  user;
	

	@OneToOne(mappedBy = "claim", cascade = CascadeType.ALL)
	private Policy policy;
	
	
	

	//@OneToOne(mappedBy = "claim", cascade = CascadeType.ALL)
	//private User user1;
	
	//@OneToOne(mappedBy = "claim", cascade = CascadeType.ALL)
	//private Policy policy;
	
	
	

	public int getClaimId() {
		return claimId;
	}

	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}

	public LocalDate getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(LocalDate claimDate) {
		this.claimDate = claimDate;
	}

	public String getClaimReason() {
		return claimReason;
	}

	public void setClaimReason(String claimReason) {
		this.claimReason = claimReason;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}
	
	
	
	
}
