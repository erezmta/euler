package com.gmail.erezmta.euler;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q3Test {

	@Test
	public void test13195() throws Exception {
		assertEquals(
				29,
				new Q3(13195L).minPrime());
	}

	@Test
	public void test600851475143() throws Exception {
		System.out.println(
				new Q3(600851475143L).minPrime());
	}
}
