package com.latis.test.repository;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface TestRepositoryCustom<T, ID extends Serializable> extends
		PagingAndSortingRepository<T, Serializable>, MongoRepository<T, Serializable> {
	public void customMethod();
}
