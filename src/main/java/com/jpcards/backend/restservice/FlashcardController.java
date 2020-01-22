package com.jpcards.backend.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpcards.backend.domain.Flashcard;
import com.jpcards.backend.repository.CardRepository;

@RestController
public class FlashcardController {
	
	@Autowired
	private CardRepository repository;	
	
	@GetMapping("/getCard")
	public Flashcard getCard() {
		return repository.findAll().get(0);
	}
}
