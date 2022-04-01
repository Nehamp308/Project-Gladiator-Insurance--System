package com.lti.serviceimpl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.VehicleDetails;
import com.lti.repository.VehicleDetailsRepositoryInterface;
import com.lti.service.VehicleDetailsServiceInterface;

/**
 * this is a VehicleDetailsService Details class implementation of VehicleDetailsServiceInterface
 * 
 * @author Chetan
 */
@Service
@Transactional
public class VehicleDetailsService implements VehicleDetailsServiceInterface {
	
	@Autowired
	private VehicleDetailsRepositoryInterface vehicleDetRepInt;

	@Override
	public VehicleDetails addNewVehicle(VehicleDetails vehicleDetails) {
		
		VehicleDetails vehDet = (VehicleDetails) vehicleDetRepInt.save(vehicleDetails);
		
		
		
		return vehDet;
		
	}

	
	
}
