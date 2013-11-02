package com.gmail.erezmta.euler;

import java.util.ArrayList;
import java.util.List;

public class Q1 {

	private int lowerThan;

	public Q1(int lowerThan) {
		this.lowerThan = lowerThan;
	}

	public List<Integer> findBelow() {
		
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 1; i < this.lowerThan; i++) {
			if(i % 3 == 0 || i % 5 == 0) {
				result.add(i);
			}
		}
		return result;
	}

	public long sumFindBelow() {
		long sum = 0l;
		
		for (Integer value : findBelow()) {
			sum += value;
		}
		
		return sum;
	}

}
