package com.basics.string;

public class MinimumManipulationToMakeAnagram {

	public static void main(String[] args) {
		System.out.println(minimumManipulation("silent", "linies"));
	}

	public static int minimumManipulation(String s1, String s2){
		if(s1.length() - s2.length() != 0){
			return -1;
		}

		int diff = 0;
		int[] charCount = getCharCount(s1);

		for(int i=0; i<s2.length(); i++){
			charCount[s2.charAt(i)-'a']--;
			if(charCount[s2.charAt(i)-'a'] < 0){
				diff++;
			}
		}

		return diff;
	}
	public static int[] getCharCount(String input){
		int[] charCount = new int[26];
		for(int i=0; i<input.length(); i++){
			charCount[input.charAt(i)-'a']++;
		}
		return charCount;
	}

}
