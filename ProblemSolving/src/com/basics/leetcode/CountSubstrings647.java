package com.basics.leetcode;

public class CountSubstrings647 {
	
	public static void main(String[] args){
		String s ="cbbd";
		System.out.println(countSubstrings(s));
	}
	
	public static int countSubstrings(String s){
		int count = 0;
		for(int i=0; i<s.length(); i++){
			count = count + search(s, i, i);
			count = count + search(s, i, i+1);
		}
		return count ;
	}
	
	public static int search(String s, int l, int r){
		int count = 0;
		while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
			l--;
			r++;
			count++;
		}
		return count;
	}

}
