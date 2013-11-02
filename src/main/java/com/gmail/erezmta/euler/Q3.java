package com.gmail.erezmta.euler;

public class Q3 {

	private long number;

	public Q3(long number) {
		this.number = number;
	}

	public long minPrime() {
		long prime = number;
		
		if(this.number == 2) {
			return 2;
		} else if(this.number == 3) {
			return 3;
		} else if(this.number == 4) {
			return 2;
		} else if(this.number == 5) {
			return 5;
		}
		
		long currentMax = this.number;
		if(isDividable(2)) {
			return recursiveCall(2);
		}
		
		for(int i = 3; i < currentMax; i+=2 ) {
			if(isDividable(i)) {
				return recursiveCall(i);
			}
		}
		
		return prime;
	}

	private boolean isDividable(int factor) {
		return this.number %factor == 0;
	}

	private long recursiveCall(int factor) {
		return new Q3(this.number / factor).minPrime();
	}

}
