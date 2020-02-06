package com.jpcards.backend.restservice;


import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpcards.backend.algo.Sm2Impl;
import com.jpcards.backend.domain.Flashcard;
import com.jpcards.backend.repository.CardRepository;

@RestController
public class FlashcardController {
	
	@Autowired
	private CardRepository repository;
	
	@CrossOrigin
	@GetMapping("/getCards")
	public List<Flashcard> getCards() {
		List<Flashcard> cards = repository.findAll();
		Collections.shuffle(cards);
		return cards;
	}
	
	@CrossOrigin
	@PutMapping("/flashcards/{quality}")
	public Flashcard updateDueDate(@RequestBody Flashcard flashcard, @PathVariable int quality) {
		//get entity
		Optional<Flashcard> ent = repository.findById(flashcard.getId());
		if (ent.isPresent()) {
			Flashcard card = ent.get();
			Sm2Impl sm2 = new Sm2Impl(card,quality);
			sm2.calcDueDate();
			return repository.save(card);
		}
		else {
			return null;
		}
		
	}
	@CrossOrigin
	@GetMapping("/getSched")
	public List<Flashcard> getSched() {
		List<Flashcard> cards = repository.findByDueDateLessThanEqual(LocalDateTime.now());
		return cards;
	}
}
