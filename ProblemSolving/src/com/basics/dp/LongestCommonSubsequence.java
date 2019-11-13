package com.basics.dp;

public class LongestCommonSubsequence {

	public static int lcs(String x, String y, int m, int n){
		if(m <0 || n< 0){
			return 0;
		}
		if(x.charAt(m) == y.charAt(n)){
			return 1 + lcs(x, y, m-1, n-1);
		}else{
			return Math.max(lcs(x,y,m,n-1), lcs(x,y,m-1,n));
		}
	}
	
	public static int lcs(String x, String y){
		int res = 0;
		int[][] T =new int[x.length()+1][y.length()+1];
		
		for(int i=0; i<T.length; i++){
			for(int j=0; j<T[0].length; j++){
				if(i == 0 || j == 0){
					T[i][j] = 0;
				}else if(x.charAt(i-1) == y.charAt(j-1)){
					T[i][j] = T[i-1][j-1]+1;
				}else{
					T[i][j] = Math.max(T[i-1][j], T[i][j-1]);
				}
				res = T[i][j] > res ? T[i][j] : res;
			}
		}
		return res;
	}
	
	
	
	public static void main(String[] args){
		String x = "ABCDHG";
		String y = "ABDCMK";
		System.out.println(lcs(x, y, x.length()-1, y.length()-1));
		System.out.println(lcs(x, y));
		
	}
}
