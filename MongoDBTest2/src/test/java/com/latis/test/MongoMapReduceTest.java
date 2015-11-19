package com.latis.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapreduce.MapReduceOptions;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { "file:src/test/resource/ApplicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class MongoMapReduceTest {
	@Autowired
	public MongoOperations mongoTemplate;
	
	@Test
	public void mapReduceTest(){
		MapReduceResults<MapReduceObject> results = mongoTemplate.mapReduce(
				"User2", // mapreduce target collection name 
				"classpath:map.js", // map function
				"classpath:reduce.js", // reduce function
				
				new MapReduceOptions().outputCollection("user_mapreduce_man"), // mapreduce result collection name
				MapReduceObject.class);// mapreduce object
		
		
		MapReduceOptions mapReduceOptions = new MapReduceOptions();
		
		
		
		
		for(MapReduceObject mapReduceObject : results){
			System.out.println(mapReduceObject);
		}
	}
}
