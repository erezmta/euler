package com.gmail.erezmta.euler;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q8Test {

	@Test
	public void testLargest5DigitProduct() throws Exception {
		assertEquals(
				40824,
				new Q8().largestProduct());
	}
}
