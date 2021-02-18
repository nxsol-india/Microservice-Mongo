package com.commons.mongo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.commons.mongo.entity.Password;
import com.commons.mongo.repository.PasswordRepository;
import com.commons.mongo.service.PasswordService;

@Service
public class PasswordServiceImpl implements PasswordService{

	@Autowired
	PasswordRepository repository;
	
	@Override
	public Page<Password> search(Pageable pageable, String searchText) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Password> readAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Optional<Password> findById(String id) {
		return repository.findById(id);
	}

	@Override
	public Password save(Password entity) {
		return repository.save(entity);
	}

	@Override
	public void deleteById(String id) {
		repository.deleteById(id);
	}

	@Override
	public ResponseEntity<?> update(String id, Password request) {
		Optional<Password> _data = repository.findById(id);

	    if (_data.isPresent()) {
	    	Password _password = _data.get();
	    	_password.setPassword_name(request.getPassword_name());
	    	_password.setPerson_id(request.getPerson_id());
	      return new ResponseEntity<>(repository.save(_password), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

	@Override
	public List<Password> readByPersonal(String id) {
		return repository.readByPersonal(id);
	}

}
