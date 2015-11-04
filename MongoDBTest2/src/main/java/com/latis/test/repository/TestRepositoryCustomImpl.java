package com.latis.test.repository;

import java.io.Serializable;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

import com.latis.test.Test123;

public class TestRepositoryCustomImpl<T, ID extends Serializable> 
	extends SimpleMongoRepository<T, Serializable>
	implements TestRepositoryCustom<T, ID>{

	public TestRepositoryCustomImpl(
			MongoEntityInformation<T, Serializable> metadata,
			MongoOperations mongoOperations) {
		super(metadata, mongoOperations);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void customMethod() {
		// TODO Auto-generated method stub
		System.out.println("!!!!!!!!!!!");
	}
	
	
	
}
