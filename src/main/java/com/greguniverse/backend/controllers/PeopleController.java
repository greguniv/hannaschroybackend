package com.greguniverse.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greguniverse.backend.exceptions.ResourceNotFoundException;
import com.greguniverse.backend.models.People;
import com.greguniverse.backend.repositories.PeopleRepository;

// POST  CREATE       /addcontact        people
//DELETE    DELETE    /deletecontact     people
//GET       READ      /allcontact        people
//UPDATE   UPDATE     /updatecontact     people

@RestController
@CrossOrigin
@RequestMapping("/api/v1/")

public class PeopleController {

	@Autowired
	private PeopleRepository peopleRepo;
	
	@GetMapping("allcontact")
	public List<People> getAllPeople() {
		return peopleRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}
	
	@PostMapping("addcontact")
	public People newContact(@RequestBody People people) {
		return peopleRepo.save(people);
	}
	
	@PutMapping("updatecontact/{id}")
	public ResponseEntity<People> updateContact(@PathVariable int id, @RequestBody People people) {
		People foundContact = peopleRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Person not found."));
		
		foundContact.setFull_name(people.getFullname());
		foundContact.setEmail(people.getEmail());
		
		People updatedContact = peopleRepo.save(foundContact);
		
		return ResponseEntity.ok(updatedContact);
	}
	
	@DeleteMapping("deletecontact/{id}")
	public ResponseEntity<String> deletePerson(@PathVariable int id) {
		peopleRepo.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Person not found."));
		String message = "Person has been deleted.";
		peopleRepo.deleteById(id);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
}
