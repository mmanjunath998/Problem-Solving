package com.basics.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Find3Sum15 {

	public static void main(String[] args){
		int[] nums = {-1,0,1,2,-1,-4};
		System.out.println(threeSum(nums));
	}
	public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < nums.length-2; ++i) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int target = -nums[i];
            int l = i+1, r = nums.length-1;
            while (l < r) {
                if (nums[l]+nums[r] > target) r--;
                else if (nums[l] + nums[r] < target) l++;
                else {
                    ret.add(Arrays.asList(nums[i], nums[l++], nums[r--]));
                    while (l < r && nums[l] == nums[l-1]) l++;
                    while (l < r && nums[r] == nums[r+1]) r--;
                }
            }
        }
        return ret;
    }
	
	
public static List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length-1; i++){
            
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            
            int left = i+1, right = nums.length-1;
            int target = -nums[i];
            while(left < right){
                
                int sum = nums[left] + nums[right];
                
                if(sum == target){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    while(left+1 < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    while(right-1 > left && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                    
                }else if(sum < target){
                    left++;
                }else{
                    right--;
                }
            } 
        }
        return result;
        
    }
}
