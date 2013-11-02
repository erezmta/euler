package com.gmail.erezmta.euler;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q4Test {

	@Test
	public void test2Digits() throws Exception {
		assertEquals(
				9009l,
				new Q4(2).maxPalindrome());
	}

	@Test
	public void test3Digits() throws Exception {
		System.out.println(new Q4(3).maxPalindrome());
	}
	
	@Test
	public void testIsPalindrome() throws Exception {
		assertTrue(Q4.isPalindrome(9009));
		assertTrue(Q4.isPalindrome(88888));
		assertTrue(Q4.isPalindrome(84348));
		
		assertFalse(Q4.isPalindrome(90098));
	}
}
