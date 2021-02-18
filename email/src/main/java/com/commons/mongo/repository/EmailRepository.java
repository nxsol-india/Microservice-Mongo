package com.commons.mongo.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.commons.mongo.entity.Email;

public interface EmailRepository extends MongoRepository<Email, String> {

	@Query("{'person_id': ?0}")
	List<Email> readByPersonal(String id);

}
