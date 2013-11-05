package com.gmail.erezmta.euler;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q11Test {

	@Test
	public void testCalcMaxProductFullTable() {
		assertEquals(
				84_852_108,
				new Q11("com/gmail/erezmta/euler/Q11.txt").calcMaxProduct());
	}

}
