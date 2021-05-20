package com.jpcards.backend.algo;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import com.jpcards.backend.domain.Flashcard;

public class Sm2Impl {
	private Flashcard flashcard;
	private int quality;
	//calculate repetitions based on quality received from user input
	public Sm2Impl(Flashcard flashcard, int quality) {
		this.flashcard = flashcard;
		this.quality = quality;
	}
	
	//use method to run SM2 algorithm to schedule card's next due date
	public void calcDueDate() {
		//determine reps
		this.updateEasiness();
		this.updateReps();
		this.updateInterval();
		LocalDateTime dueDate = LocalDateTime.now().plusDays(this.flashcard.getInterval());
//		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
//		System.out.println(dueDate.format(formatter));
		this.flashcard.setDueDate(dueDate.toEpochSecond(ZoneOffset.UTC));
//		System.out.println(this.flashcard.getDueDate());
	}
	
	private void updateReps() {
		if (this.quality < 3) {
			this.flashcard.setRepetitions(0);
		}
		else {
			this.flashcard.setRepetitions(this.flashcard.getRepetitions() + 1);			
		}	
	}
	
	private void updateInterval() {
		int reps = this.flashcard.getRepetitions();
		if (reps <= 1) {
			this.flashcard.setInterval(1);
		}
		else if (reps == 2) {
			this.flashcard.setInterval(6);
		}
		else {
			this.flashcard.setInterval((int)Math.round(this.flashcard.getInterval() * this.flashcard.getEasiness()));
		}
	}
	
	private void updateEasiness() {
		flashcard.setEasiness(Math.min(Math.max(1.3, flashcard.getEasiness() + 0.1 - (5.0 - this.quality) * (0.08 + (5.0 - this.quality) * 0.02)),2.5));
	}
		
	
}
