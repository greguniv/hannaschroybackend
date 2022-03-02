package com.greguniverse.backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="storyboards")
public class Storyboards {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String creation_date;
	@Column
	private String description;
	public int getId() {
		return id;
	}
	
	public String getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(String creation_date) {
		this.creation_date = creation_date;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
