package com.gmail.erezmta.euler;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Q8 {
	private static final int NUM_OF_DIGITS = 5;
	
	String bigNumber;

	public int largestProduct() {
		readNumber();

		LimitedQueue<Integer> latestDigits = new LimitedQueue<Integer>(
				NUM_OF_DIGITS);

		int max = 0;
		for (int i = 0; i < bigNumber.length(); i++) {
			latestDigits.add(getDigit(i));

			if (latestDigits.size() == 5) {
				int product = 1;
				for (Integer digit : latestDigits) {
					product *= digit;
				}

				if (max < product) {
					max = product;
				}
			}
		}

		return max;
	}

	private Integer getDigit(int i) {
		return Character.digit(bigNumber.charAt(i), 10);
	}

	private void readNumber() {
		FileInputStream fis = null;
		InputStreamReader reader = null;
		BufferedReader buffer = null;
		try {
			fis = new FileInputStream(this.getClass()
					.getClassLoader().getResource("com/gmail/erezmta/euler/Q8.txt").getFile());
			reader = new InputStreamReader(fis);
			buffer = new BufferedReader(reader);

			String line = null;
			StringBuilder builder = new StringBuilder();
			while (null != (line = buffer.readLine())) {
				builder.append(line);
			}

			this.bigNumber = builder.toString();
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Could not find the file", e);
		} catch (IOException e) {
			throw new RuntimeException("Error reading the file", e);
		} finally {
			closeSilently(buffer);
			closeSilently(reader);
			closeSilently(fis);
		}
	}

	private void closeSilently(Closeable closable) {
		if(closable != null) {
			try {
				closable.close();
			} catch (IOException e) {
				//Ignore
			}
		}
	}

	/**
	 * Inner Classes
	 */

	public final class LimitedQueue<E> extends LinkedList<E> {

		private static final long serialVersionUID = -2095519649575296807L;

		private int limit;

		public LimitedQueue(int limit) {
			this.limit = limit;
		}

		@Override
		public boolean add(E e) {
			boolean superResult = super.add(e);
			if (superResult == false) {
				return superResult;
			}

			while (size() > limit) {
				super.remove();
			}

			return true;
		}
	}
}
