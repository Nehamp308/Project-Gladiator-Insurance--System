package com.lti.service;

import java.util.List;


import com.lti.dto.ClaimUserDto;
import com.lti.dto.GetClaimStatus;
import com.lti.entity.Claim;
import com.lti.entity.Policy;

public interface ClaimInsuranceServiceInterface {

	public Claim addNewClaim(ClaimUserDto claimUserdto);
	

	
	public List<Claim> fetchClaimId(int id);
	
	public List<GetClaimStatus> fetchClaim(int id);
	
	//public Policy updatePolicy(ClaimUserDto claimUserDto);
}
