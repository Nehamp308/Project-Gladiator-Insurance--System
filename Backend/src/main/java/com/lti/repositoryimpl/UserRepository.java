package com.lti.repositoryimpl;

import org.springframework.stereotype.Repository;

import com.lti.entity.User;
import com.lti.entity.VehicleDetails;
import com.lti.repository.UserRepositoryInterface;

@Repository
public class UserRepository extends GenericRepository implements UserRepositoryInterface{
	
	public boolean isUserPresent(String email) {
		return (Long) entityManager.createQuery("select count(u.id) from User u where u.email= :em").setParameter("em", email).
				getSingleResult()==1 ? true : false;
	}
	
	public int fetchIdByEmailAndPassword(String email, String password) {
		return (Integer) entityManager.createQuery("select u.id from User u where u.email=:em and u.password=:ps").setParameter("em", email)
				.setParameter("ps", password).getSingleResult();
		
	}

	
	public User fetchById(int id) {
		
		return (User) entityManager.createQuery("select u from User u where u.id =: id").setParameter("id", id).getSingleResult();
	}
	
	
	
	
	

}
