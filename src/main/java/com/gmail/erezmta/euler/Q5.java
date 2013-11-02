package com.gmail.erezmta.euler;

import java.util.ArrayList;
import java.util.List;

public class Q5 {

	private int maxFactorNumber;

	public Q5(int maxFactorNumber) {
		this.maxFactorNumber = maxFactorNumber;
	}

	public long evenlyDivisable() {
		List<Integer> primes = new ArrayList<Integer>();
		
		int factor = 1;
		while(factor < maxFactorNumber) {
			int factorLeftover = factor;
			for (Integer prime : primes) {
				if(factorLeftover % prime == 0) {
					factorLeftover = factorLeftover / prime;
				}
			}
			if(factorLeftover > 1) {
				primes.add(factorLeftover);
			}
			
			factor++;
		}
		
		long product = 1;
		for (Integer prime : primes) {
			product *= prime;
		}
		return product;
	}

}
