package com.lti.repository;

import java.time.LocalDate;

import com.lti.entity.VehicleRegisteredInfo;

/**
 * Repository interface 
 * @author Urjita Kerkar
 */
public interface VehicleRegRepositoryInterface extends GenericRepositoryInterface {
	
	public VehicleRegisteredInfo fetchRegNo(String registrationNo);
	
//	public LocalDate fetchRegistrationDateByRegNo(String registrationNo);
	
	public boolean isVehicleRegistered(String registrationNo);

}
