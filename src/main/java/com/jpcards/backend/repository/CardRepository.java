package com.jpcards.backend.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jpcards.backend.domain.Flashcard;

public interface CardRepository extends MongoRepository<Flashcard, String> {

	// List<Flashcard> findAll();
	// Optional<Flashcard> findById(String primaryKey);
	List<Flashcard> findByDueDateLessThanEqual(LocalDateTime dueDate);
	// Flashcard save(Flashcard entity);
}