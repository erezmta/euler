package com.gmail.erezmta.euler;

public class Q2 {

	private int max;

	public Q2(int max) {
		this.max = max;
	}

	public long sumEven() {
		long sum = 0l;
		
		if(this.max < 2) { 
			return 0l;
		}
		
		for(	int next = 3, value = 2, prev=1; 
				value < this.max; 
				prev=value, value=next, next = value + prev) {
			
			//System.out.println(value);
			if( value % 2 == 0) {
				sum += value;
			}
		}
		
		return sum;
	}

}
