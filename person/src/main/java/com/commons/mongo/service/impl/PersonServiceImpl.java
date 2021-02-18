package com.commons.mongo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.commons.mongo.entity.Person;
import com.commons.mongo.model.EmailWeb;
import com.commons.mongo.model.PasswordWeb;
import com.commons.mongo.model.PersonWeb;
import com.commons.mongo.repository.PersonRepository;
import com.commons.mongo.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepository repository;
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public Page<PersonWeb> readAll(Pageable pageable) {
		Page<Person> person = repository.findAll(pageable);
		
		List<PersonWeb> list = new ArrayList<PersonWeb>(0);
		for (Person _person : person) {
			PersonWeb data = new PersonWeb();
			data.setPerson_id(_person.getPerson_id());
			data.setFirst_name(_person.getFirst_name());
			data.setMiddle_name(_person.getMiddle_name());
			data.setLast_name(_person.getLast_name());
			
			ResponseEntity<List<EmailWeb>> responseEntityEmailWeb =
			        restTemplate.exchange("http://EMAIL-SERVICE/email/personal/"+_person.getPerson_id(),
			            HttpMethod.GET, null, new ParameterizedTypeReference<List<EmailWeb>>() {
			            });
			List<EmailWeb> emailWeb = responseEntityEmailWeb.getBody();
			data.setEmailWeb(emailWeb);
			
			ResponseEntity<List<PasswordWeb>> responseEntity =
			        restTemplate.exchange("http://PASSWORD-SERVICE/password/personal/"+_person.getPerson_id(),
			            HttpMethod.GET, null, new ParameterizedTypeReference<List<PasswordWeb>>() {
			            });
			List<PasswordWeb> PasswordWeb = responseEntity.getBody();
			data.setPasswords(PasswordWeb);
			
			list.add(data);
		}
		
		Page<PersonWeb> personWeb = new PageImpl<PersonWeb>(list, person.getPageable(), person.getTotalElements());
		return personWeb;
	}

	@Override
	public Optional<PersonWeb> findById(String id) {
		PersonWeb data = new PersonWeb();
		
		Optional<Person> _personOptional = repository.findById(id);
		if(_personOptional.isPresent()) {
			
			Person _person = _personOptional.get();
			data.setPerson_id(_person.getPerson_id());
			data.setFirst_name(_person.getFirst_name());
			data.setMiddle_name(_person.getMiddle_name());
			data.setLast_name(_person.getLast_name());
			
			ResponseEntity<List<EmailWeb>> responseEntityEmailWeb =
			        restTemplate.exchange("http://EMAIL-SERVICE/email/personal/"+_person.getPerson_id(),
			            HttpMethod.GET, null, new ParameterizedTypeReference<List<EmailWeb>>() {
			            });
			List<EmailWeb> emailWeb = responseEntityEmailWeb.getBody();
			data.setEmailWeb(emailWeb);
			
			ResponseEntity<List<PasswordWeb>> responseEntity =
			        restTemplate.exchange("http://PASSWORD-SERVICE/password/personal/"+_person.getPerson_id(),
			            HttpMethod.GET, null, new ParameterizedTypeReference<List<PasswordWeb>>() {
			            });
			List<PasswordWeb> PasswordWeb = responseEntity.getBody();
			data.setPasswords(PasswordWeb);
		}
		return Optional.of(data);
	}

}
