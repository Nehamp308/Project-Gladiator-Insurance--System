package com.lti.repositoryimpl;

import org.springframework.stereotype.Repository;

import com.lti.entity.VehicleDetails;
import com.lti.repository.VehicleDetailsRepositoryInterface;

/**
 * this is a Vehicle Details class implementation of VehicleDetailsRepositoryInterface
 * 
 * @author Chetan
 */

@Repository
public class VehicleDetailsRepository extends GenericRepository implements VehicleDetailsRepositoryInterface{	
	
	public VehicleDetails fetchById(int id) {
		
		return (VehicleDetails) entityManager.createQuery("select v from VehicleDetails v where v.id =: id").setParameter("id", id).getSingleResult();
	}

}
