package com.commons.mongo.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.commons.mongo.model.PersonWeb;

public interface PersonService {

	Page<PersonWeb> readAll(Pageable pageable);

	Optional<PersonWeb> findById(String id);

}
