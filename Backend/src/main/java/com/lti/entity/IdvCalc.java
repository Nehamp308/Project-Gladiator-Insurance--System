package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//IDV CALCULATION
@Entity
@Table(name="tbl_dep_rate")
public class IdvCalc {

	@Id
	@Column(name="min_age")
	private double minAge;
	
	@Column(name="max_age")
	private double maxAge;
	
	@Column(name="dep_percentage")
	private double depriciationPercentage;
	
	public double getMinAge() {
		return minAge;
	}
	public void setMinAge(double minAge) {
		this.minAge = minAge;
	}
	public double getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(double maxAge) {
		this.maxAge = maxAge;
	}
	public double getDepriciationPercentage() {
		return depriciationPercentage;
	}
	public void setDepriciationPercentage(double depriciationPercentage) {
		this.depriciationPercentage = depriciationPercentage;
	}

}
