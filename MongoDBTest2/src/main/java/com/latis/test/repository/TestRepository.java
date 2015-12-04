package com.latis.test.repository;

import org.bson.types.ObjectId;

import com.latis.test.Test123;
import java.lang.String;
import java.util.List;

public interface TestRepository 
	extends TestRepositoryCustom<Test123, ObjectId>{
	List<Test123> findByName(String name);
}
