package com.lti.controllerimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.lti.dto.ClaimUserDto;
import com.lti.dto.GetClaimStatus;
import com.lti.dto.Status;
import com.lti.entity.Claim;
import com.lti.entity.Policy;
import com.lti.service.ClaimInsuranceServiceInterface;

@RestController
@CrossOrigin
public class ClaimController {

	@Autowired 
	private ClaimInsuranceServiceInterface claimServiceInt;
	
	@PostMapping("/addClaim")
	public Status addNewClaim(@RequestBody ClaimUserDto claimUserDto) {
		
		//Policy p = 
		Claim cs= claimServiceInt.addNewClaim(claimUserDto);
		//Policy p = claimServiceInt.updatePolicy(claimUserDto);
		Status c = new Status();
		c.setMessage("Claim Added ");
		c.setStatus(true);
//		c.setClaimId(cs2.getClaimId());
		
		
		return c;
	}
	
	
	
	@GetMapping("/fetchClaim")
	public List<GetClaimStatus> fetchClaim(@RequestParam("userId") int userId ) {
		List<GetClaimStatus> list = claimServiceInt.fetchClaim(userId);
		return list;
	}
	
	
		
	}

