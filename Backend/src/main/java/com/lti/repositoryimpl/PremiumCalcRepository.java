package com.lti.repositoryimpl;

import org.springframework.stereotype.Repository;

import com.lti.entity.PremiumCalc;
import com.lti.repository.PremiumCalcRepositoryInterface;

@Repository
public class PremiumCalcRepository extends GenericRepository implements PremiumCalcRepositoryInterface {

	@Override
	public PremiumCalc selectPremRateByAge(int type, int enginePower) {
		return
		 (PremiumCalc) entityManager.createQuery("from PremiumCalc pr where pr.vehicleType=:arg1 AND :arg2>=pr.minEnginePower AND :arg2<=pr.maxEnginePower")
	      .setParameter("arg1", type)
		  .setParameter("arg2", enginePower)
		  .getSingleResult();
		
	
		
	}
	
	
	

}
