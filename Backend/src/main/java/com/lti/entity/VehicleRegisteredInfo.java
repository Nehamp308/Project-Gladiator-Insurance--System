package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * this is the entity class
 * 
 * @author User
 */
@Entity
@Table(name="tbl_reg_vehicle_details")
public class VehicleRegisteredInfo {
	
	@Id
	@Column(name="vehicle_reg_no")
	private String registrationNo;
	
	@Column(name="vehicle_reg_date")
	private LocalDate registrationDate;
	
	@Column(name="vehicle_engine_power")
	private String enginePower;
	
	@Column(name="vehicle_engine_no")
	private String engineNo;
	
	@Column(name="vehicle_chassis_no")
	private String chassisNo;
	
	@Column(name="vehicle_dl")
	private String vehicleDl;
	
	@OneToOne(mappedBy = "vehicleRegInfo", cascade = CascadeType.ALL)
//	@JsonIgnore
	private Policy policy;
	
	
	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	
	public String getEnginePower() {
		return enginePower;
	}

	public void setEnginePower(String enginePower) {
		this.enginePower = enginePower;
	}

	public String getEngineNo() {
		return engineNo;
	}

	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}

	public String getChassisNo() {
		return chassisNo;
	}

	public void setChassisNo(String chassisNo) {
		this.chassisNo = chassisNo;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public String getVehicleDl() {
		return vehicleDl;
	}

	public void setVehicleDl(String vehicleDl) {
		this.vehicleDl = vehicleDl;
	}
	
}
