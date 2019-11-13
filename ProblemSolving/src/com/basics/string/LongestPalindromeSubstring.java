package com.basics.string;

public class LongestPalindromeSubstring {

	static int len;
	static int start;

	public static void main(String[] args){
		String str = "geeksforgeeks";
		String palindrome = find(str);
		System.out.println("minimum deletation "+(str.length()-palindrome.length()));
	}

	public static String find(String s){

		for(int i=0; i<s.length(); i++){
			search(s, i, i);
			//search(s, i, i+1);
		}

		String palindrome = s.substring(start, start+len);
		System.out.println(palindrome);
		return palindrome;

	}
	public static void search(String str, int l, int r){

		while(l >=0  && r < str.length() && str.charAt(l) == str.charAt(r)){
			l--;
			r++;
		}

		int dist = r-l-1;
		if(len < dist){
			len = dist;
			start = l+1;
		}
	}
}
