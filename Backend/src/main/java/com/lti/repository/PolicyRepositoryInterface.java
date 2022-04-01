package com.lti.repository;

import java.util.List;
import com.lti.dto.PolicyDto;
import com.lti.entity.Policy;

public interface PolicyRepositoryInterface extends GenericRepositoryInterface{
	
	public List<PolicyDto> fetchPolicyByUserId(int id) ;
	
	public Policy fetchPolicyByVehicleReg(String registrationNo);
	
	public Policy fetchPolicyByVehicleId(int id);
	
	
	public Policy fetchPolicyByPolicyId(int id,String regNo);
	
//	public boolean softDelete(int id);
	
	 public Policy fetchPolicyByClaimId(int id);
	 
	 public Policy fetchPolicyByPolicyId(int id);

}
