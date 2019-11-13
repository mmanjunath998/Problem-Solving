package com.basics.random;
import java.util.Arrays;


// time complexity O(n^2)

public class SortOddNumbers {
	public static void main(String[] args) {
		int[] arr = {7,3,4,2,5,1,9,8,-4,-3};
		System.out.println(Arrays.toString(sort(arr)));
	}
	public static int[] sort(int[] nums){

		for(int i=0; i<nums.length; i++){
			for(int j=i+1; j<nums.length; j++){
				if(nums[i] > nums[j] && nums[i] % 2 != 0 && nums[j] %2 != 0){
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
		return nums;
	}
}
