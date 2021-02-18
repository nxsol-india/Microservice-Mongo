package com.commons.mongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.commons.mongo.entity.Password;

public interface PasswordService {

	Page<Password> search(Pageable pageable, String searchText);

	Page<Password> readAll(Pageable pageable);

	Optional<Password> findById(String id);

	Password save(Password entity);

	void deleteById(String id);

	ResponseEntity<?> update(String id, Password request);

	List<Password> readByPersonal(String id);
}
