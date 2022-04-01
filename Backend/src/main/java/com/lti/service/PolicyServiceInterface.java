package com.lti.service;

import java.util.List;

import com.lti.dto.BuyPolicy;
import com.lti.dto.PolicyDto;
import com.lti.dto.ResultPremium;
import com.lti.dto.RenewPolicy;
import com.lti.entity.Policy;
import com.lti.entity.VehicleDetails;
import com.lti.entity.VehicleRegisteredInfo;
import com.lti.repository.PolicyRepositoryInterface;


public interface PolicyServiceInterface{

	public Policy addNewPolicy(BuyPolicy policy);
	
	public VehicleDetails fetchModelAndManu(int vId);
	
	public VehicleRegisteredInfo fetchRegNo(String regNo);
	
	public Policy fetchPolicyIdByVehicleId(int id);
	
	public List<PolicyDto> fetchPolicyByUserId(int userId);
	
	public List<Double> updatePolicyCalculation(BuyPolicy pol);
	
	public List<Double> RenewPolCalc(RenewPolicy policy);
	
	public Policy RenewPol(RenewPolicy policy);
	
	public Policy fetchPolicyByVehicleReg(String registrationNo);
}
