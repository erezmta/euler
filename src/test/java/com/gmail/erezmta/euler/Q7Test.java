package com.gmail.erezmta.euler;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q7Test {
	
	@Test
	public void test6thPrime() throws Exception {
		assertEquals(
				13d,
				new Q7(6).prime(),
				0d);
	}
	
	@Test
	public void test10kthhPrime() throws Exception {
		assertEquals(
				13d,
				new Q7(10*1000 + 1).prime(),
				0d);
	}

}
