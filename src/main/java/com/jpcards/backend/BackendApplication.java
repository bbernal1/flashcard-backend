package com.jpcards.backend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BackendApplication {


//	@Autowired
//	private CardRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//
//		for (Flashcard card : repository.findAll()) {
//
//		      System.out.println(card.getId());
//		      System.out.println(card.getWord());
//		      System.out.println(card.getDefinition());
//		    }
//	}

}
