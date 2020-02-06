package com.jpcards.backend;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.jpcards.backend.domain.Flashcard;
import com.jpcards.backend.repository.CardRepository;


@SpringBootApplication
public class BackendApplication implements CommandLineRunner{

	@Autowired
	private CardRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
		//ApplicationContext ctx =SpringApplication.run(BackendApplication.class, args);
		//String[] beans = ctx.getBeanDefinitionNames();
		//for(String s : beans) System.out.println(s);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("hey");
		for (Flashcard card : repository.findByDueDateLessThanEqual(LocalDate.now())) {
		      System.out.println("ID: " + card.getId() + "\nWord: " + card.getWord() + "\nTranslation: " + card.getTranslation() +
		    		  "\nDueDate: " + card.getDueDate().toString() + "\n");
		}

	}
}