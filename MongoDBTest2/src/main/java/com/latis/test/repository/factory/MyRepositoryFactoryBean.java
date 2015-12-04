package com.latis.test.repository.factory;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactoryBean;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

@NoRepositoryBean
public class MyRepositoryFactoryBean
	<T extends MongoRepository<S, ID>, S, ID extends Serializable> 
	extends MongoRepositoryFactoryBean<T, S, ID>{

	
	@Override
	protected RepositoryFactorySupport getFactoryInstance(
			MongoOperations operations) {
		// TODO Auto-generated method stub
		return super.getFactoryInstance(operations);
	}
	
	
	

}