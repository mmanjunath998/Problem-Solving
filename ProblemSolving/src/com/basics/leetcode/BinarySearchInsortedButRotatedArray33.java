package com.basics.leetcode;

public class BinarySearchInsortedButRotatedArray33 {
	
	public static void main(String[] args) {
		int[] arr = {3,1};
		System.out.println(find(arr, 1));
	}

	// 0 ms, faster than 100.00% 
	public static int find(int[] arr, int find){
		
		int low = 0;
		int high = arr.length-1;
		while(low <= high){
		
			int mid = (low+high)/2;
			if(arr[mid] == find){
				return mid;
			}
			//left is sorted
			if(arr[low] <= arr[mid]){
				if(find>= arr[low] && find <= arr[mid]){
					high = mid-1;	
				}else{
					low = mid+1;
				}
			}else{ //righ side is sorted
				
				if(find >= arr[mid] && find <= arr[high]){
					low = mid+1;
				}else{
					high = mid-1;
				}
			}
		}
		
		return -1;
	}
	
}
