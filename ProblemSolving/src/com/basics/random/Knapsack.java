package com.basics.random;

public class Knapsack {

	public static int find(int[] waits, int[] profits, int c, int n){
		
		if(c < 0){
			return Integer.MIN_VALUE;
		}
		if(c == 0 || n < 0){
			return  0;
		}
		
		int include = profits[n] + find(waits, profits, c-waits[n], n-1);
		
		int exclude = find(waits, profits, c, n-1);
		
		return Math.max(include, exclude);
	}
	
	public static void main(String[] args) {
		
		int capacity = 7;
		int[] prof = {1,4,5,7};
		int[] val = {1,3,4,5};
		
		System.out.println(find(val, prof, capacity, val.length-1));
	}
}
