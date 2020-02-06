package com.jpcards.backend;


import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import com.jpcards.backend.algo.Sm2Impl;
import com.jpcards.backend.domain.Flashcard;


public class Sm2ImplTest {
	Flashcard flashcard;
	int quality;

	@Before 
	public void createObjs(){
		flashcard = new Flashcard();
	}

	//test with quality less than3
	@Test
	public void zeroRepCardQualityLessThan3() {
		quality = 1;
		flashcard.setRepetitions(0);
		flashcard.setEasiness(2.5);
		flashcard.setDueDate(LocalDateTime.now());
		Sm2Impl algo = new Sm2Impl(flashcard, quality);
		algo.calcDueDate();
		assertEquals(LocalDate.now().plusDays((long)1), flashcard.getDueDate());
	}
	
	//test with many reps quality less than3
	@Test
	public void manyRepsCardQualityLessThan3() {
		quality = 1;
		flashcard.setRepetitions(6);
		flashcard.setEasiness(2.5);
		flashcard.setDueDate(LocalDateTime.now());
		Sm2Impl algo = new Sm2Impl(flashcard, quality);
		algo.calcDueDate();
		assertEquals(LocalDate.now().plusDays((long)1), flashcard.getDueDate());
	}
	
	//test with many reps quality less than3
	@Test
	public void zeroRepCardQualitymoreThan2() {
		quality = 3;
		flashcard.setRepetitions(0);
		flashcard.setEasiness(2.5);
		flashcard.setDueDate(LocalDateTime.now());
		Sm2Impl algo = new Sm2Impl(flashcard, quality);
		algo.calcDueDate();
		assertEquals(LocalDate.now().plusDays((long)1), flashcard.getDueDate());
	}
	
	//one rep quality more than 2, expect 6 days from now
	@Test
	public void oneRepCardQualitymoreThan2() {
		quality = 3;
		flashcard.setRepetitions(1);
		flashcard.setEasiness(2.5);
		flashcard.setDueDate(LocalDateTime.now());
		Sm2Impl algo = new Sm2Impl(flashcard, quality);
		algo.calcDueDate();
		assertEquals(LocalDate.now().plusDays((long)6), flashcard.getDueDate());
	}
	
	@Test
	public void manyRepsCardQualitymoreThan2() {
		quality = 2;
		flashcard.setRepetitions(3);
		flashcard.setInterval(9);
		flashcard.setEasiness(2.5);
		flashcard.setDueDate(LocalDateTime.now());
		Sm2Impl algo = new Sm2Impl(flashcard, quality);
		algo.calcDueDate();
		
		assertEquals(LocalDate.now().plusDays((long)22), flashcard.getDueDate());
	}
	
	@Test
	public void testEasinessUpperBound() {
		quality = 5;
		flashcard.setRepetitions(3);
		flashcard.setInterval(6);
		flashcard.setEasiness(2.5);
		flashcard.setDueDate(LocalDateTime.now());
		Sm2Impl algo = new Sm2Impl(flashcard, quality);
		algo.calcDueDate();
		assertEquals(2.5, flashcard.getEasiness(),0);

		//assertEquals(LocalDate.now().plusDays((long)6), flashcard.getDueDate());
	}
}
