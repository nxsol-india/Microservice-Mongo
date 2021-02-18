package com.commons.mongo.model;

import java.util.List;

public class PersonWeb {
	private String person_id;
	private String first_name;
	private String middle_name;
	private String last_name;
	
	private List<EmailWeb> emailWeb;
	private List<PasswordWeb> passwords;
	
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getMiddle_name() {
		return middle_name;
	}
	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getPerson_id() {
		return person_id;
	}
	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}
	public List<EmailWeb> getEmailWeb() {
		return emailWeb;
	}
	public void setEmailWeb(List<EmailWeb> emailWeb) {
		this.emailWeb = emailWeb;
	}
	public List<PasswordWeb> getPasswords() {
		return passwords;
	}
	public void setPasswords(List<PasswordWeb> passwords) {
		this.passwords = passwords;
	}
}
