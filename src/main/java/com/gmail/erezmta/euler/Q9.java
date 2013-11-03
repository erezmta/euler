package com.gmail.erezmta.euler;

public class Q9 {

	private int sumOfPythagorean;

	public Q9(int sumOfPythagorean) {
		this.sumOfPythagorean = sumOfPythagorean;
	}

	public int productPythagorean() {
		
		for (int c = sumOfPythagorean - 3; c > 0; c--) {
			for (int b = sumOfPythagorean - c - 1; b > 0 ; b--) {
				int a = sumOfPythagorean - b - c;
				if(Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) {
					return a * b * c;
				}
			}
			
		}
		
		return -1;
	}

}
