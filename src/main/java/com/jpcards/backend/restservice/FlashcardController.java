package com.jpcards.backend.restservice;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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
	@GetMapping("/getSched")
	public List<Flashcard> getSched() {
		List<Flashcard> cards = repository.findByDueDateLessThanEqual(LocalDate.now());
		return cards;
	}
}
