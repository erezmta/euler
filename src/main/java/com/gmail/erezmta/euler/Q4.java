package com.gmail.erezmta.euler;

public class Q4 {

	private int digits;

	public Q4(int digits) {
		this.digits = digits;
	}

	public long maxPalindrome() {
		
		long maxFactor = (long) (Math.pow(10, this.digits) - 1);
		long minFactor = (long) (Math.pow(10, this.digits - 1) - 1);
		
		long maxPalindromeFound = -1;
		
		for(
				long smallerFactor = maxFactor;
				smallerFactor >= minFactor;
				smallerFactor--) {
			
			for(
					long biggerFactor = maxFactor;
					biggerFactor >= smallerFactor;
					biggerFactor--) {
				
				long product = smallerFactor * biggerFactor;
				if(isPalindrome(product)) {
					if(maxPalindromeFound < product) {
						maxPalindromeFound = product;
					}
				}
			}
			
		}
		
		return maxPalindromeFound;
	}

	public static boolean isPalindrome(long number) {
		String numberAsString = Long.toString(number);
		
		for(int i=0; i < numberAsString.length() / 2; i++) {
			int otherSideI = numberAsString.length() - i -1;
			if(numberAsString.charAt(i) != numberAsString.charAt(otherSideI)) {
				return false;
			}
		}
		
		return true;
	}

}
