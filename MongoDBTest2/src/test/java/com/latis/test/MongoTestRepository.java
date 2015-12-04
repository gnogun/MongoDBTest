package com.latis.test;

import java.io.Serializable;
import java.util.List;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.latis.test.repository.TestRepository;
import com.latis.test.repository.TestRepositoryCustom;
import com.latis.test.repository.TestRepositoryCustomImpl;
import com.latis.test.repository.factory.MyRepositoryFactoryBean;


@ContextConfiguration(locations = { "file:src/test/resource/ApplicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class MongoTestRepository {

	/*
	@Autowired
	public MongoOperations mongoTemplate;
	
	*/
	@Autowired
	public TestRepository repository;
	
	@Test
	public void test() {
		select();
	}
	
	public void select(){
//		List<Test123> list = repository.findByName("gno");
		
		
		Iterable<Test123> list = repository.findAll();
		repository.customMethod();
		
		
		for(Test123 obj : list){
			System.out.println(obj);
		}
		
	}
}