package com.lti.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.VehicleRegisteredInfo;
import com.lti.exception.VehicleRegServiceException;
import com.lti.repository.VehicleRegRepositoryInterface;
import com.lti.service.VehicleRegServiceInterface;
/**
 * Will add registered vehicle details to db
 * @author Urjita Kerkar
 */
@Service
@Transactional
public class VehicleRegService implements VehicleRegServiceInterface {

	
	@Autowired
	private VehicleRegRepositoryInterface vehicleRegInt;
	
	public VehicleRegisteredInfo addNewVehicleRegDet(VehicleRegisteredInfo vehicleRegDetails) {
		
		if(vehicleRegInt.isVehicleRegistered(vehicleRegDetails.getRegistrationNo()))
			throw new VehicleRegServiceException("Vehicle Already registered");
			else {
			VehicleRegisteredInfo vehicle=(VehicleRegisteredInfo) vehicleRegInt.save(vehicleRegDetails);
			return vehicle;
			}
		
	}
	
	
	
	

}
