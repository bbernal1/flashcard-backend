package com.jpcards.backend.domain;

import org.springframework.data.annotation.Id;

public class Flashcard {
	@Id
	private String id;

	private String word;
	private String translation;

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


}
