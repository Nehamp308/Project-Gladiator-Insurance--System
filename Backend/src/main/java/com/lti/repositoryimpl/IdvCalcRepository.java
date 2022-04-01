package com.lti.repositoryimpl;

import org.springframework.stereotype.Repository;

import com.lti.repository.IdvCalcRepoInterface;

@Repository
public class IdvCalcRepository extends GenericRepository implements IdvCalcRepoInterface  {
	
	

      public double selectdepRateByAge(double age)  {
    	  
    	  return
		 (double) entityManager.createQuery("SELECT dr.depriciationPercentage from IdvCalc dr where :age>=dr.minAge AND :age<=dr.maxAge")
	    .setParameter("age", age).getSingleResult();

	}

}
