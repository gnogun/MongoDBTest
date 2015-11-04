package com.latis.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { "file:src/test/resource/ApplicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class MongoTest2 {

	@Autowired
	public MongoOperations mongoTemplate;

	@Test
	public void test() {
//		selectAll();
//		selectOne();
		insert();
//		update();
//		delete();
//		sort();
//		regex();

	}

	public void selectAll() {
		List<Test123> listUser = mongoTemplate.findAll(Test123.class);

		for (Test123 obj : listUser) {
			System.out.println(obj);
		}

	}
	
	public void selectOne(){
//		Query query = new Query();
//		query.addCriteria(Criteria.where("name").is("gno"));
		
		BasicQuery query = new BasicQuery("{name: 'gno'}");
		
		Test123 searchObj = mongoTemplate.findOne(query, Test123.class);
		System.out.println(searchObj);
	}

	public void insert() {
		Test123 test123 = new Test123();
		test123.setName("name123");
		test123.setQwe("qwe??qwe");
		test123.setNum(12347777);

		mongoTemplate.save(test123);

	}

	public void update() {
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is("gno"));
		
		System.out.println(query);
		
		Update update = new Update();
		update.set("qwe", "gno qwe");

		mongoTemplate.updateFirst(query, update, Test123.class);

		Test123 searchObj = mongoTemplate.findOne(query, Test123.class);

		System.out.println(searchObj);

	}

	public void delete() {
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is("name123"));
		
		System.out.println(query);
		
		Test123 obj = mongoTemplate.findOne(query, Test123.class);

		// query호 삭제
		mongoTemplate.remove(query, Test123.class);
		
		// collection object로 삭제
//		mongoTemplate.remove(obj);
		
		// collection 자체 삭제
//		mongoTemplate.dropCollection(Test123.class);
	}

	public void sort() {
		Query query = new Query();

		query.with(new Sort(Sort.Direction.ASC, "num"));
		
		System.out.println(query);

		List<Test123> list = mongoTemplate.find(query, Test123.class);

		
		for (Test123 obj : list) {
			System.out.println(obj);
		}

	}
	
	public void regex(){
		Query query = new Query();
		
		query.addCriteria(Criteria.where("name").regex("g.*?"));

		System.out.println(query);
			

		List<Test123> list = mongoTemplate.find(query, Test123.class);

		
		for (Test123 obj : list) {
			System.out.println(obj);
		}
	}
	
	

}
