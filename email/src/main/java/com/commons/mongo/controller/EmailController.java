package com.commons.mongo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.commons.mongo.entity.Email;
import com.commons.mongo.service.EmailService;


@RestController
@RequestMapping("/email")
public class EmailController {

	@Autowired
	EmailService service;

	@GetMapping("/search")
	public Page<Email> search(Pageable pageable, @RequestParam(name = "searchText", value = "", required = false) String searchText) {
		return service.search(pageable, searchText);
	}

	@GetMapping
	public Page<Email> readAll(Pageable pageable) {
		return service.readAll(pageable);
	}

	@GetMapping("/{id}")
	public Email read(@PathVariable String id) {
		return service.findById(id).orElse(null);
	}
	
	@GetMapping("/personal/{id}")
	public List<Email> readByPersonal(@PathVariable String id) {
		return service.readByPersonal(id);
	}

	@PostMapping
	public ResponseEntity<Email> create(@RequestBody Email entity) {
		try {
			return new ResponseEntity<>(service.save(entity), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody Email request) {
		Optional<Email> _data = service.findById(id);

		if (_data.isPresent()) {
			Email _email = _data.get();
			_email.setEmail_name(request.getEmail_name());
			_email.setPerson_id(request.getPerson_id());
			return new ResponseEntity<>(service.save(_email), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
