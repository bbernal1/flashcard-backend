package com.jpcards.backend.repository;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jpcards.backend.domain.Flashcard;



public interface CardRepository extends MongoRepository<Flashcard, String> {
	
	//List<Flashcard> findAll();
	//Optional<Flashcard> findById(String primaryKey);
	List<Flashcard> findByDueDateLessThanEqual(LocalDate dueDate);
	//Flashcard save(Flashcard entity);
}