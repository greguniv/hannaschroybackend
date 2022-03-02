package com.greguniverse.backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="people")
public class People {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String fullname;
	@Column
	private String email;
	@Column
	private String message;
	public int getId() {
		return id;
	}
	
	public String getFullname() {
		return fullname;
	}
	public void setFull_name(String fullname) {
		this.fullname = fullname;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
