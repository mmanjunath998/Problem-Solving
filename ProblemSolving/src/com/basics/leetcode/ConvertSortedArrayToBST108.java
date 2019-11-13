package com.basics.leetcode;

import com.basics.tree.Node;

public class ConvertSortedArrayToBST108 {

	public static void main(String[] args){
		int[] nums = {-10, -3, 0, 5, 9};
		Node res = sortedArrayToBST(nums);
		Node.print(res);
	}
	
	
	public static Node sortedArrayToBST(int[] nums){
		if(nums == null || nums.length == 0){
			return null;
		}
		
		return construct(nums, 0, nums.length-1);
	}
	
	public static Node construct(int[] nums, int left, int right){
		
		if(left > right){
			return null;
		}
		
		int mid = (left+right)/2;
		Node curr = new Node(nums[mid]);
		if(left == right){
			return curr;
		}
		
		curr.left = construct(nums, left, mid-1);
		curr.right = construct(nums, mid+1, right);
		
		return curr;
		
		
	}
}
