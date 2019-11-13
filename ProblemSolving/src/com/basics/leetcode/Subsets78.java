package com.basics.leetcode;

import java.util.ArrayList;
import java.util.List;

//Given a set of distinct integers, nums, return all possible subsets (the power set).

public class Subsets78 {

	public static void main(String[] args){
		int[] nums = {1,2,3};
		System.out.println(powerSet(nums));
		System.out.println(set(nums));
	}
	
	//Runtime: 0 ms, faster than 100.00% of Java online submissions 
	public static List<List<Integer>> powerSet(int[] nums){
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> subset = new ArrayList<>();
		
		dfs(nums, 0, subset, result);
		
		return result;
	}
	
	public static void dfs(int[] nums, int start, List<Integer> subset, List<List<Integer>> result){
		result.add(new ArrayList<>(subset));
		for(int i=start; i<nums.length; i++){
			subset.add(nums[i]);
			dfs(nums, i+1, subset, result);
			subset.remove(subset.size()-1);
		}
	}
	
	
	//Runtime: 1 ms, faster than 40.97% of Java online submissions for Subsets.
	public static List<List<Integer>> set(int[] nums){
		
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> subset = new ArrayList<>();
		result.add(subset);
		
		for(int num : nums){
			
			List<List<Integer>> copy = new ArrayList<>();
			
			for(List<Integer> prev : result){
				
				List<Integer> curr = new ArrayList<>(prev);
				curr.add(num);
				copy.add(curr);
				copy.add(prev);
			}
			
			result = copy;
		}
		
		return result;
		
	}
	
	
}
