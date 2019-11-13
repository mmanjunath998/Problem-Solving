package com.basics.array;

import java.util.ArrayDeque;
import java.util.Deque;

public class SubSet {
	
	public static void main(String[] args){
		int[] arr = {1,2,3,4};
		Deque<Integer> set = new ArrayDeque<>();
		print(arr, arr.length, set);
	}
	
	public static void print(int[] arr, int n, Deque<Integer> set){
		if(n == 0){
			System.out.println(set);
		}
		
		if(n < 1){
			return;
		}
		
		//include  1 select (1 property of 0/1 knapsack)
		set.add(arr[n-1]);
		
		print(arr, n-1, set);
		
		//exclude 0 do not select (0 property of 0/1 knapsack)
		set.removeLast();
		print(arr, n-1, set);
		
	}

}
