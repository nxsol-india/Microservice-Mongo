package com.commons.mongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.commons.mongo.entity.Email;

public interface EmailService {

	Page<Email> search(Pageable pageable, String searchText);

	Page<Email> readAll(Pageable pageable);

	Optional<Email> findById(String id);

	Email save(Email entity);

	void deleteById(String id);

	List<Email> readByPersonal(String id);
}
