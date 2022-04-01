package com.lti.repository;

import com.lti.entity.VehicleDetails;


public interface VehicleDetailsRepositoryInterface extends GenericRepositoryInterface{

	
		
		public VehicleDetails fetchById(int id);

	

}
