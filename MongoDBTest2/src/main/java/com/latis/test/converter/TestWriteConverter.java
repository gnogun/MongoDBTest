package com.latis.test.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.annotation.Id;

import com.latis.test.Test123;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class TestWriteConverter implements Converter<Test123, DBObject>{

	public DBObject convert(Test123 teset123) {
		// TODO Auto-generated method stub
		
		DBObject dbObject = new BasicDBObject();
		
		/*
		 * @Id
	private String id;
	
	private String name;
	
	private String qwe;
	
	private double num;
		 */
		dbObject.put("_id", teset123.getId());
		dbObject.put("name", teset123.getName());
		dbObject.put("qwe", teset123.getQwe());
		dbObject.put("num", teset123.getNum());
		
		return dbObject;
	}

}
