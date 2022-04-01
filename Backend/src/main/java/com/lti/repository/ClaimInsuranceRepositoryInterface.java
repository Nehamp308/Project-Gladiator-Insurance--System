package com.lti.repository;

import java.util.List;

import com.lti.entity.Claim;

public interface ClaimInsuranceRepositoryInterface extends GenericRepositoryInterface {

	public List<Claim> fetchClaimedPoliciesByUserId(int id);
	

	
    List<Claim> adminClaimsApproval();
	
	public Claim fetchByClaimId(int id);
	
	//public Claim fetchClaimId(int id) ;
	
	public Claim fetchClaimId(int id);
	
	
}
