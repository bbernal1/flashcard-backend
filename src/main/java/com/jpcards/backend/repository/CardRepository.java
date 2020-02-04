package com.jpcards.backend.repository;
import java.time.Instant;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jpcards.backend.domain.Flashcard;



public interface CardRepository extends MongoRepository<Flashcard, String> {
	List<Flashcard> findAll();
	List<Flashcard> findByDueDateLessThan(Instant dueDate);
	
}