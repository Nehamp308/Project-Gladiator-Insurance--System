package com.lti.serviceimpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;


import com.lti.dto.ClaimUserDto;
import com.lti.dto.GetClaimStatus;
import com.lti.entity.Claim;
import com.lti.entity.Policy;
import com.lti.repository.ClaimInsuranceRepositoryInterface;
import com.lti.repository.PolicyRepositoryInterface;
import com.lti.repository.UserRepositoryInterface;
import com.lti.repositoryimpl.UserRepository;
import com.lti.service.ClaimInsuranceServiceInterface;

@Service
@Transactional
public class ClaimInsuranceService implements ClaimInsuranceServiceInterface{

	@Autowired
	private ClaimInsuranceRepositoryInterface claimInsRepo;
	
	@Autowired
	private UserRepositoryInterface userRepoInt;
	
	@Autowired
	private PolicyRepositoryInterface policyRepo;
	

	public Claim addNewClaim(ClaimUserDto claimUserDto) {
		Claim c = new Claim();
		c.setClaimDate(LocalDate.now());
		c.setClaimReason(claimUserDto.getClaimReason());
		c.setClaimStatus(claimUserDto.getClaimStatus());
		c.setUser(userRepoInt.fetchById(claimUserDto.getUserId()));
//		c.setPolicy(policyRepoInt.);
		//c.setPolicy(policyRepo.fetchPolicyByUid(claimUserDto.getUserId()));
		claimInsRepo.save(c);
		Policy p = policyRepo.fetchPolicyByPolicyId(claimUserDto.getPolicyId());
		p.setClaim(claimInsRepo.fetchClaimId(claimUserDto.getUserId()));
		
		
		//p.setClaim(claimInsRepo.fetchClaimedPoliciesByUserId(claimUserDto.getUserId()));
		return c;
	}
	
//public Policy updatePolicy(ClaimUserDto claimUserDto){
//	//List<Claim> list = claimInsRepo.fetchClaimedPoliciesByUserId(claimUserDto.getUserId());
//		//List<Policy> list2 = policyRepo.fetchPolicyByPolicyId(claimUserDto.getPolicyId());
//	Policy p = policyRepo.fetchPolicyByPolicyId(claimUserDto.getPolicyId());
//	p.setClaim(claimInsRepo.fetchClaimId(claimUserDto.getUserId()));
//	claimInsRepo.save(p);
//	
//	return p;
//		
//	}
	
	
	
	
	public List<Claim> fetchClaimId(int id) {
		return claimInsRepo.fetchClaimedPoliciesByUserId(id);
	}
	
	public List<GetClaimStatus> fetchClaim(int id){
		List<Claim> list = claimInsRepo.fetchClaimedPoliciesByUserId(id);
		List<GetClaimStatus> list2 = new ArrayList<GetClaimStatus>();
		
		for(Claim c2:list)
		{
		GetClaimStatus c3 = new GetClaimStatus();
		c3.setClaimId(c2.getClaimId());
		c3.setAmount(c2.getAmount());
//		c3.setClaimDate(c2.getClaimDate());
		c3.setClaimStatus(c2.getClaimStatus());
		c3.setClaimReason(c2.getClaimReason());
		list2.add(c3);
		}
		return list2;
	}
	
	

}
