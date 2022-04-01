package com.lti.controllerimpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.BuyPolicy;
import com.lti.dto.CompTpl;
import com.lti.dto.PolicyDto;
import com.lti.dto.PolicyStatus;
import com.lti.dto.RenewInfo;
import com.lti.dto.RenewPolicy;
import com.lti.dto.ResultPremium;
import com.lti.dto.userPolicy;
import com.lti.entity.Policy;
import com.lti.entity.VehicleDetails;
import com.lti.entity.VehicleRegisteredInfo;
import com.lti.exception.CannotRenew;
import com.lti.exception.InvalidCustomerPolicyDetails;
import com.lti.service.InsuranceServiceInterface;
import com.lti.service.PolicyServiceInterface;


@CrossOrigin
@RestController
public class PolicyController {
	
	@Autowired
	private PolicyServiceInterface policyServiceInterface; 
	
	@Autowired
	@Qualifier("tpl")
	private InsuranceServiceInterface ins1;

	@Autowired
	@Qualifier("comp")
	private InsuranceServiceInterface ins2;
	
	
	@PostMapping("/addPolicy")
	public PolicyStatus addNewPolicy(@RequestBody BuyPolicy policy) {
		int vId= policy.getVehicleId();
		VehicleDetails vd = policyServiceInterface.fetchModelAndManu(vId);
		
		String regNo = policy.getRegistrationNo();
		VehicleRegisteredInfo rh = policyServiceInterface.fetchRegNo(regNo);
		
		Policy p = policyServiceInterface.addNewPolicy(policy);
//		List<Policy> list =policyServiceInterface.fetchPolicyByUserId(policy.getUserId());
		Policy p1 = policyServiceInterface.fetchPolicyIdByVehicleId(vId);
		
		PolicyStatus ps = new PolicyStatus();
		ps.setStatus(true);
		ps.setMessage("Policy added successfully");
		ps.setStartDate(p.getStartDate());
		ps.setEndDate(p.getEndDate());
//		for(Policy p1 : list) {
		ps.setId(p1.getId());
		ps.setVehicleRegNo(rh.getRegistrationNo());
		ps.setVehicleManufacturer(vd.getManufacturer());
		ps.setVehicleModel(vd.getModel());
		
		
		return ps;
	}
	@GetMapping("/userPolicies")
	public List<PolicyDto> userPolicies(@RequestParam("userId") int userId ){
		List<PolicyDto> list= policyServiceInterface.fetchPolicyByUserId(userId);
//		for(PolicyDto poldto:list) {
//			System.out.println(poldto);
//		}
		return list;
	}
	
	
	@PostMapping("/calcIns")
	public ResultPremium calPremium(@RequestBody CompTpl ct) {

		ResultPremium resultPrem=new ResultPremium();
		resultPrem.setResultTpl(ins1.calculatePremium(ct).get(0));
		System.out.println(resultPrem.getResultTpl());
		
		List<Double>list=ins2.calculatePremium(ct);
		resultPrem.setResultComp(list.get(1));
		System.out.println(resultPrem.getResultComp());
		resultPrem.setIdv(list.get(0));
		return resultPrem;
		
		
	 }
	
	@PostMapping ("/updateCalc")
	public ResultPremium updateCalc(@RequestBody BuyPolicy p) {
		
		
		ResultPremium resultPrem=new ResultPremium();
		List<Double> list = policyServiceInterface.updatePolicyCalculation(p);
		

		resultPrem.setResultTpl(list.get(0));
		resultPrem.setResultComp(list.get(1));
		resultPrem.setIdv(list.get(2));
		
		return resultPrem;
		
	}

		
	@PostMapping("/renewCalc")
	public ResultPremium RenewedCalc(@RequestBody RenewPolicy policy) {
		
		try {
		ResultPremium resultPrem=new ResultPremium();
		List<Double> list= policyServiceInterface.RenewPolCalc(policy);
		
		resultPrem.setResultTpl(list.get(0));
		resultPrem.setResultComp(list.get(1));
		resultPrem.setIdv(list.get(2));
		resultPrem.setMessage("Your idv and Premium ");
		resultPrem.setStatus(true);
		
		return resultPrem;
		}
		catch(InvalidCustomerPolicyDetails e) {
			ResultPremium resultPrem=new ResultPremium();
			resultPrem.setStatus(false);
			resultPrem.setMessage(e.getMessage());
			return resultPrem;
		}
		catch(CannotRenew ex) {
			ResultPremium resultPrem=new ResultPremium();
			resultPrem.setStatus(false);
			resultPrem.setMessage(ex.getMessage());
			return resultPrem;
		}

	}
	
	@PostMapping("/renewPolicy")
	public PolicyStatus addRenewedPolicy(@RequestBody RenewPolicy policy) {
		
		PolicyStatus ps = new PolicyStatus();
		ps.setStatus(true);
		ps.setMessage("Policy Renewed Successfully");
		Policy newPolicy=policyServiceInterface.RenewPol(policy);
//		Policy p=policyServiceInterface.fetchPolicyByVehicleReg(policy.getRegistrationNo());
		ps.setId(newPolicy.getId());
		ps.setVehicleRegNo(newPolicy.getVehicleRegInfo().getRegistrationNo());
		ps.setVehicleModel(newPolicy.getVehicle().getModel());
		ps.setVehicleManufacturer(newPolicy.getVehicle().getManufacturer());
		ps.setStartDate(newPolicy.getStartDate());
		ps.setEndDate(newPolicy.getEndDate());
		
		return ps;
		
		
	}
	
}

	
	


