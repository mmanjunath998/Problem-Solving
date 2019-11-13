package com.basics.array;

public class MedianTwoSortedArray {
	
	public static void main(String[] args){
		int[] nums1 = {1,2};
		int[] nums2 = {3,4};
		System.out.println(find(nums1, nums2));
	}

	public static double find(int[] nums1, int[] nums2){
		
		if(nums1.length > nums2.length){
			return find(nums2, nums1);
		}
		
		int x = nums1.length; 
		int y = nums2.length;
		
		int low = 0, high = x;
		
		while(low <= high){
			int partitionX = (low+high)/2;
			int partitionY = (x+y+1)/2-partitionX;
			
			int xMax = partitionX == x ? Integer.MAX_VALUE : nums1[partitionX];
			int xMin = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX-1];
			
			int yMax = partitionY == y ? Integer.MAX_VALUE : nums2[partitionY];
			int yMin = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY-1];
			
			if(xMin <= yMax && yMin <= xMax){
				
				if((x+y) % 2 == 0){
					return (double) (Math.min(xMax, yMax) + Math.max(xMin, yMin))/2;
				}else{
					return (double)Math.max(xMin, yMin);
				}
			}else if(xMin < yMax){
				low = partitionX+1;
			}else{
				high = partitionX-1;
			}
		}
		
		return -1;
	}
}
