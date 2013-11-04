package com.gmail.erezmta.euler;

import java.util.List;

import com.gmail.erezmta.euler.utils.PrimeBuilder;

public class Q10 {

	private int sumBelow;

	public Q10(int sumBelow) {
		this.sumBelow = sumBelow;
	}

	public double sumOfPrimesBelow() {
		List<Integer> primesBelow = new PrimeBuilder().calcPrimesSmallerThan(this.sumBelow - 1).getPrimes();
		
		long sum = 0L;
		for (Integer prime : primesBelow) {
			sum += prime;
		}
		
		return sum;
	}

}
