package com.basics.string;

public class LongestPalindromicSubsequence {
	
	public static void main(String[] args){
		String s  = "abcdba";
		int lps = find(s);
		System.out.println(s.length()-lps);
	}

	public static int find(String s){
		
		if(s == null || s.length() == 0){
			return 0;
		}
		
		int n = s.length();
		int[][] dp = new int[n][n];
		
		for(int i=0; i<n; i++){
			dp[i][i] = 1;
		}
		
		for(int k=1; k<n; k++){
			for(int i =0; i<n-k; i++){
				int j = i+k;
				
				if(s.charAt(i) == s.charAt(j)){
					dp[i][j] = dp[i+1][j-1] + 2;
				}else{
					dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
				}
			}
		}
		return dp[0][n-1];
	}
}
