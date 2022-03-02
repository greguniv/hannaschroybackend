package com.greguniverse.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greguniverse.backend.models.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, Integer> {
	
	List<People> findByFullname(String fullname);
	
	}
