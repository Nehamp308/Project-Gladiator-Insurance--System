package com.lti.dto;

import java.time.LocalDate;

public class PolicyStatus extends Status {
	
	private int id;
	private String vehicleRegNo;
	private String vehicleManufacturer;
	private String vehicleModel;
	private LocalDate startDate;
	private LocalDate endDate;
	
//	private int premium;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVehicleRegNo() {
		return vehicleRegNo;
	}
	public void setVehicleRegNo(String vehicleRegNo) {
		this.vehicleRegNo = vehicleRegNo;
	}
	public String getVehicleManufacturer() {
		return vehicleManufacturer;
	}
	public void setVehicleManufacturer(String vehicleManufacturer) {
		this.vehicleManufacturer = vehicleManufacturer;
	}
	public String getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
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


	
	
	
	

}
