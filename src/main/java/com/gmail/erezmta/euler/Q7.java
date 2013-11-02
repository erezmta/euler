package com.gmail.erezmta.euler;

import java.util.ArrayList;
import java.util.List;

public class Q7 {

	private int primeNumber;

	public Q7(int primeNumber) {
		this.primeNumber = primeNumber;
	}

	public double prime() {
		List<Double> primes = new ArrayList<Double>(primeNumber);

		double number = 2;
		while(primes.size() < this.primeNumber) {
			boolean isPrime = true;
			for(int i = 0; i < primes.size(); i++) {
				if(number % primes.get(i) == 0) {
					isPrime = false;
					break;
				}
			}
			
			if(isPrime) {
				primes.add(number);
			}
			number++;
		}
		
		return primes.get(this.primeNumber - 1);
	}

}
