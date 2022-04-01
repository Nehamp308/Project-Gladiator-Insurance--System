package com.lti.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="tbl_vehicle")
public class VehicleDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehicle_seq")
	@SequenceGenerator(sequenceName = "TBL_VEHICLE_VEHICLE_ID_SEQ", allocationSize = 1, name = "vehicle_seq")
	@Column(name="vehicle_id")
	private int id;
	
	@Column(name="vehicle_type")
	private String vehicleType;
	
	@Column(name="vehicle_manufacturer")
	private String manufacturer;
	
	@Column(name="vehicle_model")
	private String model;
	
	@Column(name="vehicle_price")
	private int price;
	
	@OneToOne(mappedBy = "vehicle", cascade = CascadeType.ALL)
//	@JsonIgnore
	private Policy policy;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}
	
}
