package com.lti.serviceimpl;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.CompTpl;
import com.lti.entity.PremiumCalc;
import com.lti.repository.IdvCalcRepoInterface;
import com.lti.repository.PremiumCalcRepositoryInterface;
import com.lti.repository.VehicleDetailsRepositoryInterface;
import com.lti.service.InsuranceServiceInterface;

@Service(value="comp")
@Transactional
public class ComprehensiveInsuranceService implements InsuranceServiceInterface{
	
	
	@Autowired
	IdvCalcRepoInterface idvRepo;
	
	
	@Autowired
	VehicleDetailsRepositoryInterface veh;
	
	@Autowired
	private PremiumCalcRepositoryInterface premium;

	@Override
	public List<Double> calculatePremium(CompTpl cotpl) {
		
		List<Double> list=new ArrayList<Double>();
		
		int type=cotpl.getType();
		int enginePower=cotpl.getEnginePower();
		LocalDate  regDate=cotpl.getRegDate();
	    double price= cotpl.getPrice();
	    
//	    SimpleDateFormat formatter = new SimpleDateFormat ("YYYY-MM-DD");
//	    Date d= formatter.parse(regDate);
//	    formatter.parse(regDate);
//	    System.out.println(regDate);
	    
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
	    
	  
	    
		
		PremiumCalc per=premium.selectPremRateByAge(type, enginePower);
		
		int year= regDate.getYear();
		System.out.println(year);
		
		LocalDate currentDate= LocalDate.now();
		int currentYear= currentDate.getYear();
		
		int age = currentYear - year ;
		System.out.println(age);
		
		
		if(age == 0 ) {
		       age=6;  
		    }
		
		else if(age >= 1 && age <5) {
			
		      age= age*12;
		      
		    }
		    else {
		    	
		      age= 60;
		      
		    }
		
		System.out.println(age);
		
		double deprPercent=idvRepo.selectdepRateByAge(age);
		System.out.println(deprPercent);
		double deprcost=(double)deprPercent*price/100;
		System.out.println(deprcost);
		double idv=(double) (price-deprcost);
		System.out.println(idv);
		
		double premium= per.getOwnDamagePercentage()*idv/100 + per.getTplPremium();
		double premiumWithGST= (double) (premium*1.18);
		
		list.add(idv);
		list.add(premiumWithGST);
		return list;

	}
	
	

}
