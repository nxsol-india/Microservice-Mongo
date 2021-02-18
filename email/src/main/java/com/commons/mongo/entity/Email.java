package com.commons.mongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "email")
@Getter
@Setter
public class Email {

	@Id
	private String email_id;
	private String email_name;
	private String person_id;
}
