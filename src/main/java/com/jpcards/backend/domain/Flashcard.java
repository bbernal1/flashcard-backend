package com.jpcards.backend.domain;

import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "jp")
public class Flashcard {

	@Id
	private String id;
	private String word;
	private String translation;
	private double easiness;
	private int repetitions;
	private int interval;
	private long dueDate;
	private String reading;
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

	public double getEasiness() {
		return easiness;
	}

	public void setEasiness(double easiness) {
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

	public long getDueDate() {
		return dueDate;
	}

	public void setDueDate(long localDate) {
		this.dueDate = localDate;
	}

	public String getReading() {
		return reading;
	}

	public void setReading(String reading) {
		this.reading = reading;
	}
}