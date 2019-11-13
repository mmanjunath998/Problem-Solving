package com.basics.dp;

public class LongestPalindromicSubString {

	public static String find(String s){
		if(s == null || s.isEmpty()){
			return s;
		}

		int len = s.length();
		boolean[][] T = new boolean[len][len];
		for(int i=0; i<len; i++){
			T[i][i]  =  true;
		}
		int start = 0,end = 0;
		for(int i = 1; i<len; i++){
			for(int j=0; j<len-i; j++){

				int low = j, high = j+i;

				if(s.charAt(low) == s.charAt(high)){

					if(T[low+1][high-1] && end-start <= (high-low) || (high-low == 1)){
						T[low][high] = true;
						start = low;
						end = high;						
					}
				}
			}
		}

		return s.substring(start, end+1);
	}

	public static void main(String[] args) {
		System.out.println(find("abacab"));
	}
}
