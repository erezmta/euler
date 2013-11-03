package com.gmail.erezmta.euler.utils;

import java.util.ArrayList;
import java.util.List;

public class PrimeBuilder {
	
	private List<Double> primes = new ArrayList<Double>();

	public PrimeBuilder calcNPrimes(int nPrimes) {
		for(double number = 2d; getPrimes().size() < nPrimes; number++) {
			checkAndAddPrime(number);
		}
		
		return this;
	}
	
	public PrimeBuilder calcPrimesSmallerThan(int maxPrimeExclusive) {
		for(int number = 2; number < maxPrimeExclusive; number++) {
			checkAndAddPrime(number);
		}
		
		return this;
	}

	private void checkAndAddPrime(double number) {
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
	}

	public List<Double> getPrimes() {
		return primes;
	}
}
