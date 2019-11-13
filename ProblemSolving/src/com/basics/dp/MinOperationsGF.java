package com.basics.dp;

public class MinOperationsGF {

	public static int min(int n, int m){
		
		if(n > m){
			return Integer.MAX_VALUE-1;
		}
		if(n == m){
			return 1;
		}
		
		int add = 1 + min(n+1, m);
		int dble = 1 + min(n*2, m);
		 return Math.min(add, dble);
	}
	
	
	public static int minDP(int n, int m, int[] T){
		if(n > m){
			return Integer.MAX_VALUE-1;
		}
		if( n == m){
			return 1;
		}
		if(T[n] == 0){
			int a = 1 + minDP(n+1, m, T);
			int d = 1 + minDP(n*2, m, T);
			int ans = Math.min(a, d);
			T[n] = ans;
			return ans;
		}else{
			return T[n];
		}
	}
	
	public static void main(String[] args) {
		System.out.println(min(1, 200));
		int[] T =new int[200];
		System.out.println(minDP(1, 200, T));
	}
}
