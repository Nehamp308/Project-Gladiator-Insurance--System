package com.lti.controllerimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.AdminClaim;
import com.lti.dto.Login;
import com.lti.dto.LoginStatus;
import com.lti.dto.RegisterStatus;
import com.lti.entity.User;
import com.lti.exception.UserServiceException;
import com.lti.service.UserServiceInterface;
import com.lti.serviceimpl.UserService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserServiceInterface userServiceInterface;
	
	@PostMapping("/register")
	public RegisterStatus register(@RequestBody User user) {
		try {
			int id = userServiceInterface.register(user);
			RegisterStatus st = new RegisterStatus();
			st.setStatus(true);
			st.setMessage("Registered successfully");
			st.setRegisteredCustomerId(id);
			return st;
		}
		
		catch(UserServiceException e){
			RegisterStatus st = new RegisterStatus();
			st.setStatus(false);
			st.setMessage(e.getMessage());
			return st;
			
		}
		
	}
	
	@PostMapping("/login")
	public LoginStatus login(@RequestBody Login login) {
		try {
			User user = userServiceInterface.login(login.getEmail(), login.getPassword());
			LoginStatus loginStatus = new LoginStatus();
			loginStatus.setStatus(true);
			loginStatus.setMessage("Login successful!");
			loginStatus.setUserId(user.getId());
			loginStatus.setName(user.getName());
			return loginStatus;
		}
		catch(UserServiceException e) {
			LoginStatus loginStatus = new LoginStatus();
			loginStatus.setStatus(false);
			loginStatus.setMessage(e.getMessage());		
			return loginStatus;
		}
	}
	
	@GetMapping("/adminDashboard")
		public List<AdminClaim> showClaimToAdmin()
		{
			return userServiceInterface.claimsForAdmin();
		}
	@PostMapping("/updatedClaim")
	    public boolean updatedClaimByAdmin(@RequestBody AdminClaim adminclaimDto) {
		
		return userServiceInterface.updateClaimByAdmin(adminclaimDto);
	}

}
