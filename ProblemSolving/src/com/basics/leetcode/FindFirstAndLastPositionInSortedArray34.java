package com.basics.leetcode;

import java.util.Arrays;

public class FindFirstAndLastPositionInSortedArray34 {

	public static void main(String[] args){
		int[] nums = {5,7,7,8,8,8,10};
		int x = 8;
		System.out.println(Arrays.toString(searchRange(nums, x)));
	}
	public static int[] searchRange(int[] nums, int target){
		int[] res = new int[2];
		res[0] = findLeft(nums, target);
		res[1] = findRight(nums, target);
		return res;
	}
	
	public static int findLeft(int[] nums, int target){
		int low = 0, high = nums.length-1;
		
		while(low <= high){
			int mid = (low+high)/2;
			if(nums[mid] == target && (mid == 0 || mid-1 >= 0 && nums[mid-1] != target)){
				return mid;
			}else if(nums[mid] == target || nums[mid] > target){
				high = mid-1;
			}else{
				low = mid+1;
			}
		}
		return -1;
	}
	
	public static int findRight(int[] nums, int target){
		int low = 0, high = nums.length-1;
		
		while(low <= high){
			int mid = (low+high)/2;
			if(nums[mid] == target && (mid == nums.length-1 || mid+1 < nums.length && nums[mid+1] != target)){
				return mid;
			}else if(nums[mid] == target || nums[mid] < target){
				low = mid+1;
			}else{
				high = mid-1;
			}
		}
		return -1;
	}
}
