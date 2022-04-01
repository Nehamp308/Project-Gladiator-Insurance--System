package com.lti.dto;

import java.time.LocalDate;
/**
 * This class contains fields that will be displayed on dashboard
 * @author Urjita Kerkar
 */
public class VehicleRegInfo extends Status {

	private String regNo;
	private LocalDate dateOfReg;
	
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public LocalDate getDateOfReg() {
		return dateOfReg;
	}
	public void setDateOfReg(LocalDate dateOfReg) {
		this.dateOfReg = dateOfReg;
	}
	
}
