package com.lti.serviceimpl;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dto.AdminClaim;
import com.lti.entity.Claim;
import com.lti.entity.Policy;
import com.lti.entity.User;
import com.lti.exception.UserServiceException;
import com.lti.repository.ClaimInsuranceRepositoryInterface;
import com.lti.repository.PolicyRepositoryInterface;
import com.lti.repository.UserRepositoryInterface;
import com.lti.service.UserServiceInterface;

@Service
@Transactional
public class UserService implements UserServiceInterface {
	
	@Autowired
	private UserRepositoryInterface userRepositoryInterface;
	
	@Autowired
	private ClaimInsuranceRepositoryInterface claimRepo;
	
	@Autowired
	private PolicyRepositoryInterface polRepo;
	
	public int register(User user) {
		if(userRepositoryInterface.isUserPresent(user.getEmail())) throw new UserServiceException("User already registered");
		
		else {
			user.setPassword(Base64.getEncoder().encodeToString(user.getPassword().getBytes()));
			User updateCust = (User) userRepositoryInterface.save(user);
			
			return updateCust.getId();
		}
		
	}
	
	public User login(String email, String password) {
		try {
			password= Base64.getEncoder().encodeToString(password.getBytes());
			int id = userRepositoryInterface.fetchIdByEmailAndPassword(email, password);
			User user = userRepositoryInterface.find(User.class, id);
			return user;
		}
		
		catch(NoResultException e){
			throw new UserServiceException("Invalid username/password");
			
		}
	}
	
	public List<AdminClaim> claimsForAdmin()
    {
    	List<AdminClaim> claimsAdmin= new ArrayList<AdminClaim>();
    	List<Claim> list= claimRepo.adminClaimsApproval();
    	Policy p=new Policy();
    	for(Claim c:list)
    	{
    		AdminClaim admin = new AdminClaim();
    		admin.setClaimId(c.getClaimId());
   		    p= polRepo.fetchPolicyByClaimId(c.getClaimId());
    		admin.setClaimAmount(c.getAmount());
    		admin.setClaimDate(c.getClaimDate());
    		admin.setClaimStatus(c.getClaimStatus());
    		admin.setClaimReason(c.getClaimReason());
    		admin.setPolicyId(p.getId());
    		admin.setIdv(p.getIdv());
    		
    		claimsAdmin.add(admin);
    	}
    	
    	return claimsAdmin;
    }
	
	public boolean updateClaimByAdmin(AdminClaim adminclaimDto)
    {
    	int num=(int) adminclaimDto.getClaimId();
    	System.out.println(num);
    	Claim c=claimRepo.fetchByClaimId(num);
    	c.setAmount(adminclaimDto.getClaimAmount());
    	c.setClaimStatus("Approved");
        claimRepo.save(c);
        boolean isUpdated=true;
    	return isUpdated;
    }
	
	

}
