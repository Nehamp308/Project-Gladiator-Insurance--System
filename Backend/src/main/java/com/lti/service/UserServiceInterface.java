package com.lti.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lti.dto.AdminClaim;
import com.lti.entity.User;


public interface UserServiceInterface {
	
	public int register(User user);
	
	public User login(String email, String password);
	
	List<AdminClaim> claimsForAdmin();
	
	public boolean updateClaimByAdmin(AdminClaim adminclaimDto);
	

}
