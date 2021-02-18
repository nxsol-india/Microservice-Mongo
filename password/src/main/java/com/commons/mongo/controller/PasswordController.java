package com.commons.mongo.controller;

import java.util.List;

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

import com.commons.mongo.entity.Password;
import com.commons.mongo.service.PasswordService;


@RestController
@RequestMapping("/password")
public class PasswordController {
	
	@Autowired
	PasswordService service;

	@GetMapping("/search")
	public Page<Password> search(Pageable pageable, @RequestParam(name = "searchText", value = "", required = false) String searchText) {
		return service.search(pageable, searchText);
	}

	@GetMapping
	public Page<Password> readAll(Pageable pageable) {
		return service.readAll(pageable);
	}

	@GetMapping("/personal/{id}")
	public List<Password> readByPersonal(@PathVariable String id) {
		return service.readByPersonal(id);
	}

	
	@GetMapping("/{id}")
	public Password read(@PathVariable String id) {
		return service.findById(id).orElse(null);
	}

	@PostMapping
	public ResponseEntity<Password> create(@RequestBody Password entity) {
		try {
			return new ResponseEntity<>(service.save(entity), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable String id, @RequestBody Password request) {
		return service.update(id, request);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
