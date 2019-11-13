package com.basics.array;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class SubSetEqualsToSum {

	public static void main(String[] args){
		
		int[] arr = {3,5,7,4,6};
		ArrayDeque<Integer> set = new ArrayDeque<>();
		System.out.println(find(arr, arr.length-1, 13, set));
		Map<String, Boolean> lookup = new HashMap<String, Boolean>();
		
		find(arr, arr.length-1, 13, set, lookup);
		
	}

	public static boolean find(int[] arr, int n, int sum, ArrayDeque<Integer> set){
		if(sum == 0){
			System.out.println(set);
			return true;
		}
		//base case
		if(n < 0 || sum < 0){
			return false;
		}
		
		set.addFirst(arr[n]);
		boolean include = find(arr, n-1, sum-arr[n], set);
		
		set.removeFirst();
		boolean exclude = find(arr, n-1, sum, set);
		
		return include || exclude;
	}
	
	public static boolean find(int[] arr, int n , int sum, ArrayDeque<Integer> set, Map<String, Boolean> lookup){
		
		if(sum == 0){
			System.out.println(set);
			return true;
		}
		if(n < 0 || sum < 0){
			return false;
		}
		
		String key = n+"|"+sum;
		
		if(!lookup.containsKey(key)){
			set.add(arr[n]);
			boolean include = find(arr, n-1, sum-arr[n], set, lookup);
			
			set.removeLast();
			boolean exclude = find(arr, n-1, sum, set, lookup);
			boolean res = include || exclude;
			lookup.put(key, res);
		}
		return lookup.get(key);
	}
}
