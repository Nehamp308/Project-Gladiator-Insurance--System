package com.lti.repositoryimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.entity.Claim;
import com.lti.repository.ClaimInsuranceRepositoryInterface;

@Repository
public class ClaimInsuranceRepository extends GenericRepository implements ClaimInsuranceRepositoryInterface  {


	@Override
	public List<Claim> fetchClaimedPoliciesByUserId(int id) {
		return entityManager.createQuery("Select c from Claim c where c.user.id = : uid")
				.setParameter("uid", id).getResultList();
		

	}
	
public Claim fetchClaimId(int id) {
		return (Claim) entityManager.createQuery("select c from Claim c where c.user.id=:uid").setParameter("uid",id).getSingleResult();
	}

	public List<Claim> adminClaimsApproval() {

		List<Claim> claimList = entityManager.createQuery("select c from Claim c where c.claimStatus='pending'")
				.getResultList();
		return claimList;
	}
    
	public Claim fetchByClaimId(int id) {
		
		return (Claim) entityManager.createQuery("select c from Claim c where c.id=:cid")
				.setParameter("cid", id)
				.getSingleResult();
	}

	

}
