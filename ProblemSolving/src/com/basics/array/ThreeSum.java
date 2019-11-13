package com.basics.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args){

		int[] nums = {-1,0,1,2,-1,-4};
		System.out.println(find(nums));
	}

	public static List<List<Integer>> find(int[] nums){
		List<List<Integer>> result = new ArrayList<>();

		Arrays.sort(nums);

		for(int i=0; i<nums.length; i++){
			
			if(i > 0 && nums[i] == nums[i-1]){
				continue;
			}
		
			int target = -nums[i];
			int left = i+1;
			int right = nums.length-1;


			while(left < right){
				if(target == nums[left]+nums[right]){
					result.add(Arrays.asList(nums[i], nums[left], nums[right]));

					while(left < right && nums[left] == nums[left+1]){
						left++;
					}
					while(right > 0 && nums[right] == nums[right-1]){
						right--;
					}
					left++;
					right--;

				}else if(target < nums[left]+nums[right]){
					right--;
				}else{
					left++;
				}
			}
		}


		return result;
	}
}
