package com.commons.mongo.controller;

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

import com.commons.mongo.entity.Person;
import com.commons.mongo.model.PersonWeb;
import com.commons.mongo.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonService service;

	@GetMapping
	public Page<PersonWeb> readAll(Pageable pageable) {
		return service.readAll(pageable);
	}

	@GetMapping("/{id}")
	public PersonWeb read(@PathVariable String id) {
		return service.findById(id).orElse(null);
	}

	

}
