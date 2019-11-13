package com.basics.array;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

	public static void main(String[] args){
		int[] nums = {1,2,3,4};
		System.out.println(setDFS(nums));
	}
	
	
	public static List<List<Integer>> setDFS(int[] nums){
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
	
	
	
	

	public static List<List<Integer>> set(int[] nums){
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> empty = new ArrayList<>();

		result.add(empty);
		for(int i=0; i<nums.length; i++){
			int num = nums[i];

			List<List<Integer>> copy = new ArrayList<>();
			for(List<Integer> list : result){
				List<Integer> r = new ArrayList<>();
				for(int l : list){
					r.add(l);
				}
				r.add(num);
				copy.add(list);
				copy.add(r);
			}
			result = copy;
		}
		return result;
	}
	
	public static List<List<Integer>> powerSet(int[] nums){
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> empty = new ArrayList<>();
		result.add(empty);
		for(int num : nums){
			
			List<List<Integer>> copy = new ArrayList<>();
			
			for(List<Integer> prev : result){
				List<Integer> curr = new ArrayList<>();
				for(int p : prev){
					curr.add(p);
				}
				curr.add(num);
				copy.add(prev);
				copy.add(curr);
			}
			
			result = copy;
		}
		return result;
	}
	
}
