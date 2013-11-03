package com.gmail.erezmta.euler;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q9Test {

	@Test
	public void testPythagoreanSum12() {
		assertEquals(
				3 * 4 * 5,
				new Q9(12).productPythagorean());
	}
	
	@Test
	public void testPythagoreanSum1000() {
		assertEquals(
				31_875_000,
				new Q9(1000).productPythagorean());
	}

}
