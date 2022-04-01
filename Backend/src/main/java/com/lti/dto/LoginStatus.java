package com.lti.dto;

public class LoginStatus extends Status {

	private int userId;
	private String name;
	//private Customer customer;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
