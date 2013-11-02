package com.gmail.erezmta.euler;

import java.text.NumberFormat;

public class Q6 {

	private int numberNaturalNumbers;

	public Q6(int numberNaturalNumbers) {
		this.numberNaturalNumbers = numberNaturalNumbers;
	}

	public double sumDiff() {
		return squareOfSums() - sumOfSquares(); 
	}

	private double sumOfSquares() {
		double sum = 0d; 
		
		for(int i = 1; i <= this.numberNaturalNumbers; i++) {
			sum += Math.pow(i, 2);
		}
		
		return sum;
	}

	private double squareOfSums() {
		double sum = 0d;
		
		for(int i = 1; i <= this.numberNaturalNumbers; i++) {
			sum += i;
		}

		return Math.pow(sum, 2);
	}

}
