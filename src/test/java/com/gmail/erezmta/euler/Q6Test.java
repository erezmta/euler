package com.gmail.erezmta.euler;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q6Test {

	@Test
	public void test10NaturalNumbers() throws Exception {
		assertEquals(
				2640d,
				new Q6(10).sumDiff(),
				0
				);
	}

	@Test
	public void test100NaturalNumbers() throws Exception {
		assertEquals(
				25164150d,
				new Q6(100).sumDiff(),
				0
				);
	}
}
