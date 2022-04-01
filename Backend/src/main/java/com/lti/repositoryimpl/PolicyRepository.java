package com.lti.repositoryimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lti.dto.PolicyDto;
import com.lti.entity.Policy;
import com.lti.repository.PolicyRepositoryInterface;

@Repository

public class PolicyRepository extends GenericRepository implements PolicyRepositoryInterface {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	public List<PolicyDto> fetchPolicyByUserId(int id) {
		
//		return  entityManager.createQuery("select new com.lti.dto.PolicyDto(p.id,p.registrationNo,p.vehicleId) from Policy p  inner join p.user u where u.id = :uid").setParameter("uid", id).getResultList();
		return  entityManager.createQuery("select new com.lti.dto.PolicyDto(p.id,p.policyType,p.startDate,p.endDate,p.idv,p.premium,p.vehicleRegInfo.registrationNo) "
				+ " FROM Policy p INNER JOIN  p.vehicleRegInfo v INNER JOIN  p.vehicle r INNER JOIN  p.user u  WHERE p.user.id = :uid")
				.setParameter("uid", id).getResultList();
	}

	
	public Policy fetchPolicyByVehicleReg(String registrationNo) {
		
		return (Policy) entityManager.createQuery("select p from Policy p where p.vehicleRegInfo.registrationNo = :regNo").setParameter("regNo", registrationNo).getSingleResult();
	}

	
	public Policy fetchPolicyByVehicleId(int id) {
		
		return (Policy) entityManager.createQuery("select p from Policy p where p.vehicle.id = :vid").setParameter("vid", id).getSingleResult();
	}
	
    public Policy fetchPolicyByClaimId(int id) {
		
		return (Policy) entityManager.createQuery("select p from Policy p where p.claim.claimId = :cid").setParameter("cid", id).getSingleResult();
	}
    
    public Policy fetchPolicyByPolicyId(int id) {
    	return (Policy) entityManager.createQuery("select p from Policy p where p.id= :pid").setParameter("pid", id).getSingleResult();
    }

	public Policy fetchPolicyByPolicyId(int id,String regNo) {
		try {
		return (Policy) entityManager.createQuery("select p from Policy p where p.id=:pid and p.vehicleRegInfo.registrationNo = :regNo")
			      .setParameter("pid",id)
				  .setParameter("regNo",regNo)
				  .getSingleResult();
		}
		catch(NoResultException e) {
			return null;
		}
	}


	
//   public boolean softDelete(int id) {
//	   return (boolean) entityManager.createQuery("update Policy p set p.vehicleRegInfo.registrationNo = :regNo,p.vehicle.id = :vid where p.id= :pid")
//			         .setParameter("pid", id)
//			         .setParameter("regNo",null)
//			         .setParameter("vid",null)
//			         .getSingleResult();
//			         
//}
	
	
}
