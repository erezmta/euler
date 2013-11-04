package com.gmail.erezmta.euler.utils;

import java.util.ArrayList;
import java.util.List;

public class PrimeBuilder {
	
	private List<Integer> primes = new ArrayList<Integer>();

	public PrimeBuilder calcNPrimes(int nPrimes) {
		for(int number = 2; getPrimes().size() < nPrimes; number++) {
			checkAndAddPrime(number);
		}
		
		return this;
	}
	
	public PrimeBuilder calcPrimesSmallerThan(int maxPrimeExclusive) {
		if(2 < maxPrimeExclusive) {
			addPrime(2);
		}
		if(3 < maxPrimeExclusive) {
			addPrime(3);
		}
		
		int number;
		for(number = 5; number < maxPrimeExclusive - 6; number+=6) {
			//Removing all numbers divided by "2" and "3"
			checkAndAddPrime(number);      //Think of it as "5"
			checkAndAddPrime(number + 2);  // "7"
		}

		int manual;
		manual = number    ; if(manual < maxPrimeExclusive) { checkAndAddPrime(manual); }
		manual = number + 2; if(manual < maxPrimeExclusive) { checkAndAddPrime(manual); }
		manual = number + 6; if(manual < maxPrimeExclusive) { checkAndAddPrime(manual); }
		
		
		return this;
	}

	private void checkAndAddPrime(int number) {
		boolean isPrime = true;
		isPrime = verifyNotPrime(number, isPrime);
		
		if(isPrime) {
			addPrime(number);
		}
	}

	private boolean verifyNotPrime(int number, boolean isPrime) {
		double sqrt = Math.sqrt(number);
		for(int i = 0; (i < getPrimes().size()) && (getPrime(i) <= sqrt); i++) {
			if(isNotPrime(number, i)) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}

	private boolean isNotPrime(int number, int i) {
		return number % getPrime(i) == 0;
	}

	private Integer getPrime(int i) {
		return primes.get(i);
	}

	private void addPrime(int number) {
		getPrimes().add(number);
	}

	public List<Integer> getPrimes() {
		return primes;
	}
}
