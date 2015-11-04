package com.latis.test.converter;

import org.bson.types.ObjectId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.annotation.Id;

import com.latis.test.Test123;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class TestReadConverter implements Converter<DBObject, Test123>{

	public Test123 convert(DBObject dbObject) {
		Test123 test123 = new Test123();
		test123.setId((ObjectId) dbObject.get("_id"));
		test123.setName((String) dbObject.get("name"));
		test123.setQwe((String) dbObject.get("qwe"));
		test123.setNum((Double) dbObject.get("num"));
		
		return test123;
	}

	

}
