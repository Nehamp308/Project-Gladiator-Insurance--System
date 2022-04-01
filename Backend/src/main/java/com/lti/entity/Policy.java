package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.SQLDelete;

import com.fasterxml.jackson.annotation.JsonIgnore;

//Policy entity class
@Entity
@Table(name="tbl_policy")
//@SQLDelete(sql = “UPDATE tbl_policy (SET) deleted=true WHERE id = ?”)


public class Policy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "policy_seq")
	@SequenceGenerator(sequenceName = "TBL_POLICY_POLICY_ID_SEQ", allocationSize = 1, name = "policy_seq")
	@Column(name="policy_id")
	private int id;
	
	@Column(name="policy_type")
	private String policyType;
	
	@Column(name="policy_premium")
	private double premium;
	
	@Column(name="policy_start_date")
	private LocalDate startDate;
	
	@Column(name="policy_end_date")
	private LocalDate endDate;
	
	@Column(name="policy_idv")
	private double idv;
	
	
	@Column(name="transaction_id")
	private int transactionId;
	
	@Column(name="transaction_date")
	private LocalDate transactionDate; 
	
	@Column(name="policy_duration")
	private int duration;
	
//	@Column(name="state")
//	private String state; 
	
//	@ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
//	@OneToOne(fetch = FetchType.EAGER)
	@OneToOne
	@JoinColumn(name="vehicle_id" ,nullable = true)
	private VehicleDetails vehicle;
	
//	@OneToOne(fetch = FetchType.EAGER)
	@OneToOne
	@JoinColumn(name="vehicle_reg_no",nullable = true)
	private VehicleRegisteredInfo vehicleRegInfo; 
	
	/*@OneToOne
	@JoinColumn(name="claim_id")
	private Claim claim; */
	
	@OneToOne
	@JoinColumn (name = "claim_id")
	private Claim claim;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
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

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public VehicleDetails getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleDetails vehicle) {
		this.vehicle = vehicle;
	}
	
	

	public VehicleRegisteredInfo getVehicleRegInfo() {
		return vehicleRegInfo;
	}

	public void setVehicleRegInfo(VehicleRegisteredInfo vehicleRegInfo) {
		this.vehicleRegInfo = vehicleRegInfo;
	}
	
	

	public Claim getClaim() {
		return claim;
	}

	public void setClaim(Claim claim) {
		this.claim = claim;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	
	
	
	
	

}
