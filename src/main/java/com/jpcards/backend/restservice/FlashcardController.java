package com.jpcards.backend.restservice;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
//import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	@GetMapping("/flashcards")
	public List<Flashcard> getCards() {
		System.out.println("Getting cards");
		List<Flashcard> cards = repository.findAll();
		//Collections.shuffle(cards);
		return cards;
	}
	
	@CrossOrigin
	@DeleteMapping("/flashcards/{id}")
	public void deleteFlashcard(@PathVariable String id) {
		System.out.println("Deleting card");
		Optional<Flashcard> ent = repository.findById(id);
		Flashcard flashcard = ent.get();
		repository.delete(flashcard);
	}
	
	@CrossOrigin
	@PostMapping("/flashcards")
	public Flashcard newFlashcard(@RequestBody Flashcard newFlashcard) {
		System.out.println("Adding card");
		newFlashcard.setDueDate(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
		return repository.save(newFlashcard);
	}
	
	@CrossOrigin
	@PutMapping("/flashcard/{quality}")
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
}
