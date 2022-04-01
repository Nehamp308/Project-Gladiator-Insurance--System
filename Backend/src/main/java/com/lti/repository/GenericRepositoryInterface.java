package com.lti.repository;

public interface GenericRepositoryInterface {
	
	public Object save(Object obj) ;
	
	public <E> E find(Class<E> classs, Object pk );

}
