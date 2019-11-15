package com.basics.array;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class ReplaceByRank {
	public static void main(String[] args) {
		int[] nums = {4, 2, 3, 7,3,2};
		replace(nums);
	}


	public static int[] replace(int[] nums){
		System.out.println(Arrays.toString(nums));
		Map<Integer, Integer> map = new TreeMap<>();
		
		for(int i=0; i<nums.length; i++){
			map.put(nums[i], i);
		}
		
		int rank = 1;
		for(Map.Entry<Integer, Integer> entry : map.entrySet()){
			
			nums[entry.getValue()] = rank++;
		}
		
		System.out.println(map);
		System.out.println(Arrays.toString(nums));
		
		
		return nums;
	}
}
