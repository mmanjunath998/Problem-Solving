package com.basics.lt;

import java.util.ArrayList;
import java.util.List;

public class Permutations46 {
	
	public static void main(String[] args){
		int[] arr = {1,2,3};
		System.out.println(permute(arr));
	}

	public static List<List<Integer>> permute(int[] nums){
		List<List<Integer>> result = new ArrayList<>();
		permute(nums, 0, nums.length-1, result);
		return result;
	}
	
	public static void permute(int[] nums, int l, int r, List<List<Integer>> result){
		
		if(l == r){
			List<Integer> list = new ArrayList<>();
			for(int num : nums){
				list.add(num);
			}
			result.add(list);
		}else{
			
			for(int i=l; i<=r; i++){
				swap(nums, l, i);
				permute(nums, l+1, r, result);
				swap(nums, l, i);
			}
		}
	}
	
	public static void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
