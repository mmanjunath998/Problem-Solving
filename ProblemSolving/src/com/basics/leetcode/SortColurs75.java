package com.basics.leetcode;

import java.util.Arrays;

public class SortColurs75 {
	
	public static void main(String[] args){
		int[] arr = {2,0,2,1,1,0};
		System.out.println(Arrays.toString(sort(arr)));
	}

	
	public static int[] sort(int[] nums){
		int low = 0, mid = 0, high = nums.length-1;
		
		while(mid <= high){
			if(nums[mid] == 1){
				mid++;
			}else if(nums[mid] == 0){
				swap(nums, low, mid);
				low++;
				mid++;
			}else{
				swap(nums, mid, high);
				high--;
			}
		}
		
		return nums;
	}
	
	public static void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
