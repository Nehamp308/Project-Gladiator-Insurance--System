package com.lti.repository;

import com.lti.entity.PremiumCalc;


public interface PremiumCalcRepositoryInterface extends GenericRepositoryInterface {
	
	
	
	public PremiumCalc selectPremRateByAge(int type,int enginePower);
	
		
		
	
		

	

}
