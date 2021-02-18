package com.commons.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.commons.mongo.entity.Password;

public interface PasswordRepository extends MongoRepository<Password, String> {

	@Query("{'person_id': ?0}")
	List<Password> readByPersonal(String id);
}
