package com.basics.dp;

public class LongestCommonSubstring {

	public static int lcs(String x, String y, int m, int n,int count){
		if(m == 0 || n == 0){
			return count;
		}
		if(x.charAt(m-1) == y.charAt(n-1)){
			count = lcs(x,y,m-1,n-1,count+1);
		}else{
			int max = Math.max(lcs(x,y,m-1,n,0), lcs(x,y,m,n-1,0));
			count = Math.max(count, max);
		}
	return count;	
	}
	
	
	public static int lcs(String x, String y){
		int res = 0;
		int[][] T =new int[x.length()+1][y.length()+1];
		
		for(int i=0; i<T.length; i++){
			for(int j=0; j<T[0].length; j++){
				if(i == 0 || j == 0){
					T[i][j] = 0;
				}else if(x.charAt(i-1) == y.charAt(j-1)){
					T[i][j] = 1 + T[i-1][j-1];
				}else{
					T[i][j] = 0;
				}
				
				res = T[i][j] > res ? T[i][j] : res;
			}
		}
		
		return res;
	}
	
	
	public static void main(String[] args){
		String x = "ABCDGH";
		String y = "ACDGHR";
		System.out.println(lcs(x, y, x.length(), y.length(), 0));
		System.out.println(lcs(x, y));
		
	}
}
