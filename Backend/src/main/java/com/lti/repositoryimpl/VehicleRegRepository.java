package com.lti.repositoryimpl;

import java.time.LocalDate;

import org.springframework.stereotype.Repository;

import com.lti.entity.VehicleDetails;
import com.lti.entity.VehicleRegisteredInfo;
import com.lti.repository.VehicleRegRepositoryInterface;
/**
 * This class will fetch registered vehicle details
 * @author Urjita Kerkar
 */
@Repository
public class VehicleRegRepository extends GenericRepository implements VehicleRegRepositoryInterface  {

	@Override
	public VehicleRegisteredInfo fetchRegNo(String registrationNo) {
		
		return (VehicleRegisteredInfo) entityManager.createQuery("select v from VehicleRegisteredInfo v where v.registrationNo =: rgno").setParameter("rgno", registrationNo).getSingleResult();
	}

//	@Override
//	public LocalDate fetchRegistrationDateByRegNo(String registrationNo) {
//		
//		return (LocalDate) 
//				entityManager.createQuery("select v.registrationDate from VehicleRegisteredInfo v where v.registrationNo=:rgno")
//		.setParameter("rgno", registrationNo)
//		.getSingleResult();
//	}

	@Override
	public boolean isVehicleRegistered(String registrationNo) {
		
		return(Long)
				 entityManager
				.createQuery("select count(v.registrationNo) from VehicleRegisteredInfo v where v.registrationNo=:rgno")
				.setParameter("rgno", registrationNo)
				.getSingleResult() == 1 ? true : false;	
	}
	
}
