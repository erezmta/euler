package com.gmail.erezmta.euler;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q5Test {

	@Test
	public void testTill10() throws Exception {
		assertEquals(
				2520,
				new Q5(10).evenlyDivisable());
	}

	@Test
	public void testTill20() throws Exception {
		System.out.println(new Q5(20).evenlyDivisable());
	}
}
