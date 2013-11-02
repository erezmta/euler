package com.gmail.erezmta.euler;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q2Test {

	@Test
	public void testSumTill10() throws Exception {
		assertEquals(
				10,
				new Q2(10).sumEven());
	}

	@Test
	public void testSumTill4M() throws Exception {
		System.out.println(
				new Q2(4 * (int) Math.pow(10, 6)).sumEven());
	}
}
