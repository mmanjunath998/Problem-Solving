package com.basics.array;

import java.util.HashMap;
import java.util.Map;

public class StraiCase {
	
	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		System.out.println(climbStairs(43, map));
	}

	public static int climbStairs(int n, Map<Integer, Integer> map) {
		
		if(map.containsKey(n)){
			return map.get(n);
		}
		if(n <= 1){
			return 1;
		}
		int val = climbStairs(n-1, map)+climbStairs(n-2, map);
		map.put(n, val);
		
		return map.get(n);
	}
}
