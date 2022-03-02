package com.greguniverse.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greguniverse.backend.models.Storyboards;

@Repository
public interface StoryboardRepository extends JpaRepository<Storyboards, Integer> {
	List<Storyboards> findById(int id);
}
