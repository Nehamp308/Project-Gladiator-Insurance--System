package com.lti.service;

import java.util.List;

import com.lti.dto.CompTpl;

public interface InsuranceServiceInterface {
	
	public List<Double> calculatePremium(CompTpl cotpl);

}
