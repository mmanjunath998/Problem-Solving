package com.basics.leetcode;

public class MinimumWindowSubstring76 {
	
	public static void main(String[] args) {
		String val = "ADOBECODEBANC";
		String pat = "ABC";
		System.out.println(minWindow(val, pat));
				
	}

	
	public static String minWindow(String val, String pat){
	
		String res = "";
		int min = Integer.MAX_VALUE;
		int[] patCount = new int[256];
		int[] valCount = new int[256];
		
		for(int i=0; i<pat.length(); i++){
			patCount[pat.charAt(i)]++;
		}
		int start = 0;
		int count = 0;
		for(int i=0; i<val.length(); i++){
			
			char c = val.charAt(i);
			valCount[c]++;
			
			if(patCount[c] != 0 && valCount[c] <= patCount[c]){
				count++;
			}
			
			if(count >= pat.length()){
				
				while(patCount[val.charAt(start)] == 0 || valCount[val.charAt(start)] > patCount[val.charAt(start)]){
					
					if(valCount[val.charAt(start)] > patCount[val.charAt(start)]){
						valCount[val.charAt(start)]--;
					}
					start++;
				}
				
				int minimum = i-start+1;
				if(minimum < min){
					min = minimum;
					res = val.substring(start, i+1);
				}
			}
		}
		return res;
	}
}
