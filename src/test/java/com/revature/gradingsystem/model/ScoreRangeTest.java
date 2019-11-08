package com.revature.gradingsystem.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScoreRangeTest {

	@Test
	public void testScoreRange() {
		ScoreRange scoreRange = new ScoreRange();
		
		scoreRange.setGrade("A");
		scoreRange.setMin(56);
		scoreRange.setMax(90);
		
		assertEquals(scoreRange.getGrade(), "A");
		assertEquals(scoreRange.getMin(), 56);
		assertEquals(scoreRange.getMax(), 90);
		
	}

}
