package com.jpcards.backend.domain;

import java.time.Instant;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

public class Flashcard {
	
	@Id
	private String id;
	private String word;
	private String translation;
	private double easiness;
	private int repetitions;
	private int interval;
	private Instant dueDate;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	public Double getEasiness() {
		return easiness;
	}

	public void setEasiness(Double easiness) {
		this.easiness = easiness;
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}



	public int getRepetitions() {
		return repetitions;
	}

	public void setRepetitions(int repetitions) {
		this.repetitions = repetitions;
	}

	public Instant getDueDate() {
		return dueDate;
	}

	public void setDueDate(Instant dueDate) {
		this.dueDate = dueDate;
	}


}
