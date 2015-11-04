package com.latis.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration(locations = { "file:src/test/resource/ApplicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class MongoTestIndex {

	@Autowired
	public MongoOperations mongoTemplate;

	@Test
	public void test() {
		index();
	}
	
	public void index(){
		mongoTemplate.getCollection("test123").createIndex("name");
	}
}