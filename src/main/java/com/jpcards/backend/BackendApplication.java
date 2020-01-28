package com.jpcards.backend;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpcards.backend.domain.Flashcard;
import com.jpcards.backend.repository.CardRepository;


@SpringBootApplication
public class BackendApplication implements CommandLineRunner{


	@Autowired
	private CardRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		for (Flashcard card : repository.findAll()) {
		      System.out.println("ID: " + card.getId() + "\nWord: " + card.getWord() + "\nTranslation: " + card.getTranslation() +
		    		  "\nDueDate: " + card.getDueDate().toString() + "\n");
		}

	}

}
