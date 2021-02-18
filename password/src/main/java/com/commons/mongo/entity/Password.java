package com.commons.mongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "passwords")
public class Password {

	@Id
	private String password_id;
	private String password_name;
	private String person_id;
	
	public Password() {
	}
	public Password(String password_name, String person_id) {
		this.password_name = password_name;
		this.person_id = person_id;
	}
	public String getPassword_id() {
		return password_id;
	}
	public void setPassword_id(String password_id) {
		this.password_id = password_id;
	}
	public String getPassword_name() {
		return password_name;
	}
	public void setPassword_name(String password_name) {
		this.password_name = password_name;
	}
	public String getPerson_id() {
		return person_id;
	}
	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}
	@Override
	public String toString() {
		return "Password [password_id=" + password_id + ", password_name=" + password_name + ", person_id=" + person_id
				+ "]";
	}
	
	
	
}
