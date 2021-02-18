package com.commons.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.commons.mongo.entity.Person;

public interface PersonRepository extends MongoRepository<Person, String> {

}
