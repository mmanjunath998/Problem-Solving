package com.basics.string;

public class LongestPalindromicSubstring {

	public static void main(String[] args){
		String str = "gadagtest";
		find(str);
	}
	public static void find(String str){
		int n = str.length();
		boolean[][] T = new boolean[n][n];
		int start = 0;
		int len  = 0;
		for(int k=0; k<n; k++){
			
			for(int i=0; i<n-k; i++){
				int j = i+k;
				
				if(str.charAt(i) == str.charAt(j) && (j-i <= 1 || T[i+1][j-1])){
					T[i][j] = true;
					int size = j-i+1;
					if(size > len){
						len = size;
						start = i;
					}
				}
			}
		}
		System.out.println(str.substring(start, start+len));
	}
}
