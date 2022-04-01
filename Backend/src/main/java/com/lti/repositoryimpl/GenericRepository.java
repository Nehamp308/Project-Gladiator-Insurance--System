package com.lti.repositoryimpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class GenericRepository {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	public Object save(Object obj) {
		Object updatedObj = entityManager.merge(obj);
		return updatedObj;
		
	}
	
	public <E> E find(Class<E> classs, Object pk ) {
		E e = entityManager.find(classs, pk);
		return e;
	}

}
