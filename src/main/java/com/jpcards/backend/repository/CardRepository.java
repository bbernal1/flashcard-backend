package com.jpcards.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jpcards.backend.domain.Flashcard;

public interface CardRepository extends MongoRepository<Flashcard, String> {

}