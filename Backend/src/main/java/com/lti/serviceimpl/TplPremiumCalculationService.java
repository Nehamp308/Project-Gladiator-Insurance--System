package com.lti.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.CompTpl;
import com.lti.entity.PremiumCalc;
import com.lti.repository.PremiumCalcRepositoryInterface;
import com.lti.service.InsuranceServiceInterface;

@Service(value="tpl")
@Transactional
public class TplPremiumCalculationService implements InsuranceServiceInterface {
	
	@Autowired
	private PremiumCalcRepositoryInterface premium;
	
	
	public List<Double> calculatePremium(CompTpl cotpl) {
		List<Double> list=new ArrayList<Double>();
		
		int type=cotpl.getType();
		int enginePower=cotpl.getEnginePower();
		PremiumCalc per=premium.selectPremRateByAge(type, enginePower);
		list.add(per.getTplPremium());
		return list;
		
		
	}
	
	

}
