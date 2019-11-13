package com.basics.string;

public class CheckForAnagrams {
	public static void main(String[] args) {
		String s1 = "abcda";
		String s2 = "cdabb";
		System.out.println(isAnagram(s1, s2));
		
	}

	
	public static boolean isAnagram(String s1, String s2){
		
		if(s1.length()-s2.length() != 0){
			return false;
		}
		
		int[] charCount1 = getCharCount(s1);
		int[] charCount2 = getCharCount(s2);
		
		for(int i=0; i<s1.length(); i++){
			if(charCount1[s1.charAt(i)-'a'] != charCount2[s1.charAt(i)-'a']){
				return false;
			}
		}
		
		return true;
	}
	
	public static int[] getCharCount(String s){
		int[] charCount = new int[26];

		for(int i=0; i<s.length(); i++){
			charCount[s.charAt(i)-'a']++;
		}
		
		return charCount;
	}
}
