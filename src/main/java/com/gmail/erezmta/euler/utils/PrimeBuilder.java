package com.gmail.erezmta.euler.utils;

import java.util.ArrayList;
import java.util.List;

public class PrimeBuilder {
	
	private List<Double> primes = new ArrayList<Double>();

	public PrimeBuilder calcPrimesUntil(int max) {

		double number = 2;
		while(getPrimes().size() < max) {
			boolean isPrime = true;
			for(int i = 0; i < getPrimes().size(); i++) {
				if(number % getPrimes().get(i) == 0) {
					isPrime = false;
					break;
				}
			}
			
			if(isPrime) {
				getPrimes().add(number);
			}
			number++;
		}
		
		return this;
	}

	public List<Double> getPrimes() {
		return primes;
	}
}
