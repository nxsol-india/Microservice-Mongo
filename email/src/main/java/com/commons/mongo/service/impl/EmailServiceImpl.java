package com.commons.mongo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.commons.mongo.entity.Email;
import com.commons.mongo.repository.EmailRepository;
import com.commons.mongo.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	EmailRepository repository;

	@Override
	public Page<Email> search(Pageable pageable, String searchText) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Email> readAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Optional<Email> findById(String id) {
		return repository.findById(id);
	}

	@Override
	public Email save(Email entity) {
		return repository.save(entity);
	}

	@Override
	public void deleteById(String id) {
		repository.deleteById(id);
	}

	@Override
	public List<Email> readByPersonal(String id) {
		return repository.readByPersonal(id);
	}

}
