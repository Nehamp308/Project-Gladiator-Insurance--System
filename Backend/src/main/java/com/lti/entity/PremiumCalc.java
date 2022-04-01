package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_premium_rate")
public class PremiumCalc {

	@Id
	@Column(name="third_party_premium")
	private double tplPremium;
	
	@Column(name="vehicle_type")
    private int vehicleType;
	
	@Column(name="min_engine_power")
	private int minEnginePower;	
	
	@Column(name="max_engine_power")
	private int maxEnginePower;
	
	@Column(name="own_damage_prem_perc")
	private double ownDamagePercentage;
	
	public double getTplPremium() {
		return tplPremium;
	}
	public void setTplPremium(double tplPremium) {
		this.tplPremium = tplPremium;
	}
	public int getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(int vehicleType) {
		this.vehicleType = vehicleType;
	}
	public int getMinEnginePower() {
		return minEnginePower;
	}
	public void setMinEnginePower(int minEnginePower) {
		this.minEnginePower = minEnginePower;
	}
	public int getMaxEnginePower() {
		return maxEnginePower;
	}
	public void setMaxEnginePower(int maxEnginePower) {
		this.maxEnginePower = maxEnginePower;
	}
	public double getOwnDamagePercentage() {
		return ownDamagePercentage;
	}
	public void setOwnDamagePercentage(double ownDamagePercentage) {
		this.ownDamagePercentage = ownDamagePercentage;
	}
	

}
