package com.gmail.erezmta.euler.google;

public class EscapeString {

	public static void main(String[] args) {
		String str = "a\tb";
		System.out.println(str);
		System.out.println(escape(str));
	}

	private static String escape(String str) {
		StringBuffer buf = new StringBuffer(str);
		
		for(int i=0, bufI=0; i < str.length(); i++, bufI++) {
			char c = str.charAt(i);
			if(c < ' ') {
				String charEscaped = escapeChar(c);
				buf.replace(bufI, bufI + 1, charEscaped);
			}
		}
		
		return buf.toString();
	}

	private static String escapeChar(char c) {
		int charAsInt = (int) c;
		
		return String.format("\\%03o", (int)c);
	}
}
