package com.gmail.erezmta.euler.google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AnagramsYoav {
	
		public static void main(String[] args) {
			List<String> testDictionary = Arrays.asList("abc", "bca", "ddd");
			
			AnagramsYoav anagramsYoav = new AnagramsYoav(testDictionary);
			anagramsYoav.preProcess();
			
			printAnagrams(anagramsYoav, "abc");
			printAnagrams(anagramsYoav, "cab");
			printAnagrams(anagramsYoav, "ddd");
			printAnagrams(anagramsYoav, "dde");
		}

		private static void printAnagrams(AnagramsYoav anagramsYoav, String word) {
			System.out.println("Anagrams for word: " + word + ": " + anagramsYoav.getAnagrams(word));
		}
	
		private final List<String> dictionary;
		private final Map<WordCharacters, List<String>> charsToWords = new HashMap<WordCharacters, List<String>>();

		public AnagramsYoav(List<String> dictionary) {
			this.dictionary = dictionary;
		}

		public void preProcess() {
			for(String word : this.dictionary) {
				WordCharacters chars = new WordCharacters(word);
				List<String> words = charsToWords.get(chars);
				if(words == null) {
					words = new LinkedList<String>();
					this.charsToWords.put(chars, words);
				}
				words.add(word);
			}
			
			System.out.println(this.charsToWords);
		}

		/**
		 *@Returns - List of anagrams to given word from pre-processed dictionary.
		 * 		  	null if word does not exist in dictionary.
		*/
		public List<String> getAnagrams(String word) {
			WordCharacters chars = new WordCharacters(word);
			
			return this.charsToWords.get(chars);
		}

		public static final class WordCharacters {
			private String sortedChars;
			
			public WordCharacters(String word) {
				this.sortedChars = new String(sortChars(word) );
			}

			private static char[] sortChars(String word) {
				char[] chars = new char[word.length()];
				word.getChars(0, word.length(), chars, 0);
				Arrays.sort(chars);//Do not remember exact syntax

				return chars;
			}

			@Override
			public int hashCode() {
				return this.sortedChars.hashCode();
			}

			@Override
			public boolean equals(Object obj) {
				if(this == obj) {
					return true;
				}
				
				if (! (obj instanceof WordCharacters) ) {
					return false;
				}
				
				
				WordCharacters other = (WordCharacters) obj;
				
				return this.sortedChars.equals(other.sortedChars);
			}
			
			@Override
			public String toString() {
				return this.sortedChars;
			}
		}

}
