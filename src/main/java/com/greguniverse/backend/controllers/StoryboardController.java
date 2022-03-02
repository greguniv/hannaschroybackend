package com.greguniverse.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greguniverse.backend.models.Storyboards;
import com.greguniverse.backend.repositories.StoryboardRepository;

//GET     READ        /allstoryboards    storyboard DESCs

@RestController
@CrossOrigin
@RequestMapping("/api/v1/")
public class StoryboardController {
	
	@Autowired
	private StoryboardRepository storyboardRepo;
	
	@GetMapping("allstoryboards")
	public List<Storyboards> getAllStoryboards() {
		return storyboardRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}
	
}
