package com.basics.leetcode;

import java.util.HashSet;
import java.util.Set;

public class WordBreak139 {

	public static void main(String[] args){
		Set<String> dict = new HashSet<>();
		dict.add("leet");
		dict.add("code");
		dict.add("is");
		System.out.println(wordBreak("isleetcode", dict));
	}
	
	public static boolean wordBreak(String word, Set<String> dict){

		int n = word.length();

		boolean[] dp = new boolean[n];

		for(int i=0; i<n; i++){
			for(int j=0; j<=i; j++){
				if(j == 0 || dp[j-1]){
					
					String sub = word.substring(j, i+1);
					
					if(dict.contains(sub)){
						dp[i] = true;
					}
				}
			}
		}
		return dp[n-1];
	}
}
