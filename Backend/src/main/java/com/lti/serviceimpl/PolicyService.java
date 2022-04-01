package com.lti.serviceimpl;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dto.BuyPolicy;
import com.lti.dto.CompTpl;
import com.lti.dto.PolicyDto;
import com.lti.dto.RenewPolicy;
import com.lti.entity.Policy;
import com.lti.entity.User;
import com.lti.entity.VehicleDetails;
import com.lti.entity.VehicleRegisteredInfo;
import com.lti.exception.CannotRenew;
import com.lti.exception.InvalidCustomerPolicyDetails;
import com.lti.repository.ClaimInsuranceRepositoryInterface;
import com.lti.repository.PolicyRepositoryInterface;
import com.lti.repository.UserRepositoryInterface;
import com.lti.repository.VehicleDetailsRepositoryInterface;
import com.lti.repository.VehicleRegRepositoryInterface;
import com.lti.service.InsuranceServiceInterface;
import com.lti.service.PolicyServiceInterface;


@Service
@Transactional
public class PolicyService implements PolicyServiceInterface {
	
    @Autowired
    private PolicyRepositoryInterface policyRepo;
    
    @Autowired
    private UserRepositoryInterface userRepo;
    
    @Autowired
    private VehicleRegRepositoryInterface vehRegRepo;
    
    @Autowired
   	@Qualifier("tpl")
   	private InsuranceServiceInterface ins1;

   	@Autowired
   	@Qualifier("comp")
   	private InsuranceServiceInterface ins2;
    
    @Autowired
    private VehicleDetailsRepositoryInterface vehDetRepo;
    
    @Autowired
    private ClaimInsuranceRepositoryInterface claimRepo;
    
	public Policy addNewPolicy(BuyPolicy policy) {
		
	
		
		Policy p = new Policy();
		
		p.setPolicyType(policy.getPolicyType());
		p.setDuration(policy.getDuration());
		p.setStartDate(LocalDate.now());
		p.setEndDate(LocalDate.now().plusYears(policy.getDuration()));
		p.setTransactionDate(LocalDate.now());
	    
		
		
		p.setVehicleRegInfo(vehRegRepo.fetchRegNo(policy.getRegistrationNo()));
	
		p.setVehicle(vehDetRepo.fetchById(policy.getVehicleId()));
	
        p.setUser(userRepo.fetchById(policy.getUserId()));
        
       // p.setClaim(claimRepo.fetchClaimId(policy.getClaimId()));
        
        p.setIdv(policy.getIdv());
        p.setPremium(policy.getPremium());
     

		policyRepo.save(p);
		
		return p;
	}
	
	public VehicleDetails fetchModelAndManu(int vId) {
		return vehDetRepo.fetchById(vId);
	}


	public VehicleRegisteredInfo fetchRegNo(String regNo) {
		return vehRegRepo.fetchRegNo(regNo);
	}


	public Policy fetchPolicyIdByVehicleId(int id) {
		return policyRepo.fetchPolicyByVehicleId(id);
	}
	
	
	public List<PolicyDto> fetchPolicyByUserId(int userId) {
		return policyRepo.fetchPolicyByUserId(userId);
		
	}
	
	public Policy fetchPolicyByVehicleReg(String registrationNo) {
		return policyRepo.fetchPolicyByVehicleReg(registrationNo);
	}
	
	public List<Double> RenewPolCalc(RenewPolicy policy) {
				
		int policyId = policy.getPolicyId();
		System.out.println(policyId);
		Policy oldPolicy=policyRepo.fetchPolicyByPolicyId(policy.getPolicyId(),policy.getRegistrationNo());
		if (Objects.isNull(oldPolicy)) {
			throw new InvalidCustomerPolicyDetails("Either Registration number is incorrect or Policy ID");
		}
		else {
		//fetch vehicle registration information
		VehicleRegisteredInfo regVehDetail = oldPolicy.getVehicleRegInfo();
		
		//fetch vehicle detail information
		VehicleDetails vehicle = oldPolicy.getVehicle();
		
		LocalDate endDate=oldPolicy.getEndDate();
		LocalDate currDate=LocalDate.now();
		
		Period period = Period.between(endDate,currDate);
		
        System.out.print(period.getYears() + " years,");
        System.out.print(period.getMonths() + " months,");
        System.out.print(period.getDays() + " days");
        if(period.getYears()==0 && period.getMonths()==0 && period.getDays()<=10 && period.getDays()!=0)  {
        	
            System.out.print("renew");
    		//Add new Policy
            CompTpl calc=new CompTpl();
            
    		List<Double> list=new ArrayList<Double>();
    		calc.setType(Integer.parseInt(vehicle.getVehicleType()));
    		calc.setRegDate(regVehDetail.getRegistrationDate());
    		calc.setPrice(vehicle.getPrice());
    		calc.setEnginePower(Integer.parseInt(regVehDetail.getEnginePower()));
    		
    		list.add(ins1.calculatePremium(calc).get(0)); //third party premium
    		list.add(ins2.calculatePremium(calc).get(1)); //comprehensive prmium
    		list.add(ins2.calculatePremium(calc).get(0)); //idv
    		
    		
    		return list;
    	
//    		if(policy.getPlan().equalsIgnoreCase("Third Party Premium")) {
//    			newPolicy.setPremium(ins1.calculatePremium(calc).get(0));
//    		}
//    		else {
//    			newPolicy.setPremium(ins2.calculatePremium(calc).get(1));
//    		}
    		
    		            }
            else {
            	throw new CannotRenew("Policy can be renewed within 10 days before expiry / Policy has been expired");
            }

    		
    	}
        
 }
	

	@Override
	public List<Double> updatePolicyCalculation(BuyPolicy pol) {
		
		VehicleDetails v = vehDetRepo.fetchById(pol.getVehicleId());
		VehicleRegisteredInfo vg= vehRegRepo.fetchRegNo(pol.getRegistrationNo());
		
		 CompTpl calc=new CompTpl();
		
		List<Double> list=new ArrayList<Double>();
		calc.setType(Integer.parseInt(v.getVehicleType()));
		calc.setRegDate(vg.getRegistrationDate());
		calc.setPrice(v.getPrice());
		calc.setEnginePower(Integer.parseInt(vg.getEnginePower()));
		
		   return list;
        
		  
		}
	
	
	public Policy RenewPol(RenewPolicy policy) {
		
		int policyId = policy.getPolicyId();
		System.out.println(policyId);
		Policy oldPolicy=policyRepo.fetchPolicyByPolicyId(policy.getPolicyId(),policy.getRegistrationNo());
		System.out.println("retrived");
        VehicleRegisteredInfo regVehDetail = oldPolicy.getVehicleRegInfo();
        User u=oldPolicy.getUser();
		//fetch vehicle detail information
		VehicleDetails vehicle = oldPolicy.getVehicle();
		
//		String regNo=null;
//		int vid=0;
//		policyRepo.softDelete(regNo,vid);
		
//		oldPolicy.setVehicle(null);
//		oldPolicy.setVehicleRegInfo(null);
//	    policyRepo.save(oldPolicy);
	    
	    System.out.println("deleted");
	    
		Policy newPolicy = new Policy();
	    
		newPolicy.setPolicyType(policy.getPlan());
		newPolicy.setId(oldPolicy.getId());
		newPolicy.setStartDate(oldPolicy.getEndDate());
		int year=policy.getDuration();
		newPolicy.setEndDate(oldPolicy.getEndDate().plusYears(year));
		newPolicy.setVehicle(vehicle);
		newPolicy.setTransactionDate(LocalDate.now());
		newPolicy.setVehicleRegInfo(regVehDetail);
		newPolicy.setIdv(policy.getIdv());
		newPolicy.setPremium(policy.getPremium());
		newPolicy.setUser(u);
		newPolicy.setTransactionId(12);
		
		policyRepo.save(newPolicy); // New Policy added
		System.out.println("New policy added");
		
		return newPolicy;
		
	}
	

}

