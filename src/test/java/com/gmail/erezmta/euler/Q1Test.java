package com.gmail.erezmta.euler;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class Q1Test {

	@Test
	public void testFindBelow10() throws Exception {
		assertEquals(
				Arrays.asList(3,5,6,9),
				new Q1(10).findBelow());
	}

	@Test
	public void testSumFindBelow10() throws Exception {
		assertEquals(
				23l,
				new Q1(10).sumFindBelow());
	}
	
	@Test
	public void testSumFindBelow1000() throws Exception {
		System.out.println(
				new Q1(1000).sumFindBelow());
	}
}
