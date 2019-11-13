package com.basics.leetcode;
/*
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 */
public class ContainerWithMostWater11 {
	
	public static void main(String[] args){
		int[] arr = {1,8,6,2,5,4,8,3,7};
		System.out.println(find(arr));
		System.out.println(findO(arr));
		
	}

	
	public static int findO(int[] height){
		int maxArea = Integer.MIN_VALUE;
		
		int start = 0;
		int end = height.length-1;
		
		while(start < end){
			
			int len = Math.min(height[start], height[end]);
			int width = end-start;
			maxArea = Math.max(maxArea, len * width);
			if(height[start] <= height[end]){
				start++;
			}else{
				end--;
			}
		}
		
		return maxArea;
	}
	
	public static int find(int[] height){
		int maxArea = Integer.MIN_VALUE;
		
		for(int i=0; i<height.length; i++){
			for(int j=i+1; j<height.length; j++){
				int len = Math.min(height[i], height[j]);
				int width = j-i;
				maxArea = Math.max(maxArea, len*width);

			}
		}
		return maxArea;
	}
}
