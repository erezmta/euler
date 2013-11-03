package com.gmail.erezmta.euler;

import com.gmail.erezmta.euler.utils.PrimeBuilder;

public class Q7 {

	private int primeNumber;

	public Q7(int primeNumber) {
		this.primeNumber = primeNumber;
	}

	public double prime() {
		return new PrimeBuilder().
				calcNPrimes(this.primeNumber).
				getPrimes().
				get(this.primeNumber - 1);
	}

}
