package com.gmail.erezmta.euler;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

public class TestQ10 {

	@Test
	public void testSumPrimesBelow10() {
		assertEquals(
				17d, 
				new Q10(10).sumOfPrimesBelow(),
				0d);
	}
	
	@Test
	public void testSumPrimesBelow2M() {
		assertEquals(
				142_913_828_922D, 
				new Q10(2_000_000).sumOfPrimesBelow(),
				0d);
	}
}
