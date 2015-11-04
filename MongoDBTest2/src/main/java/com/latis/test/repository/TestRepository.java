package com.latis.test.repository;

import org.bson.types.ObjectId;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.latis.test.Test123;
import java.lang.String;
import java.util.List;

public interface TestRepository extends PagingAndSortingRepository<Test123, ObjectId>{
	List<Test123> findByName(String name);
}
