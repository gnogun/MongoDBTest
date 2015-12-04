package com.latis.test.repository.factory;

import java.io.Serializable;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.BasicMongoPersistentEntity;
import org.springframework.data.mongodb.core.mapping.MongoPersistentEntity;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.MappingMongoEntityInformation;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactory;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.util.ClassTypeInformation;

import com.latis.test.repository.TestRepositoryCustomImpl;

public class MyRepositoyFactory<T, ID extends Serializable> extends
		MongoRepositoryFactory {

	private MongoOperations mongoOperations;
	
	public MyRepositoyFactory(MongoOperations mongoOperations) {
		super(mongoOperations);
		
		this.mongoOperations = mongoOperations;
		
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Object getTargetRepository(RepositoryInformation information) {
		// TODO Auto-generated method stub
		return super.getTargetRepository(information);
	}


}
