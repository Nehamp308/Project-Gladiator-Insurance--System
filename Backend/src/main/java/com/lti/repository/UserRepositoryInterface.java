package com.lti.repository;

import com.lti.entity.User;

public interface UserRepositoryInterface extends GenericRepositoryInterface{
	
	public boolean isUserPresent(String email);
	
	public int fetchIdByEmailAndPassword(String email, String password);
    
	public User fetchById(int id);
}
