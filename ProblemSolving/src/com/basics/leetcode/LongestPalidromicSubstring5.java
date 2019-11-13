package com.basics.leetcode;

public class LongestPalidromicSubstring5 {

	
	public static void main(String[] args) {
		String s ="cbbd";
		System.out.println(find(s));
	}
	
	static int longest = 0;
	static int start = 0; 
	
	//runs faster  5 ms, faster than 96.76% of J
	public static String find(String s){
		
		for(int i=0; i<s.length()/2; i++){
			search(s, i, i);
			search(s, i, i+1);
		}
		return s.substring(start, start+longest);
	}
	
	public static void search(String s , int l, int r){
		while(l >= 0 && r <s.length() && s.charAt(l) == s.charAt(r)){
			l--;
			r++;
		}
		
		int size = r-l-1;
		if(size > longest){
			longest = size;
			start = l+1;
		}
	}

	//this passes with 29 ms, faster than 48.73% of
	public static String longestPalindrome(String s){
		int n = s.length();
		if(s == null || n <= 1){
			return s;
		}
		int start = 0, end = 0;
		
		boolean[][] T = new boolean[n][n];
		
		for(int l=0; l<n; l++){
			for(int i=0; i<n-l; i++){
				int j = i+l;
				if(s.charAt(i) == s.charAt(j) && (j-i <=1 || T[i+1][j-1])){
					T[i][j] = true;
					if(end-start <= j-i){
						start = i;
						end = j;
					}
				}
			}
		}
		return s.substring(start, end+1);
	}
}
