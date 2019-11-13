package com.basics.array;

public class FindNumInSortedButRotated {

	public static void main(String[] args){
		int[] arr = {5,6,8,9,10,4};
		System.out.println(pivote(arr));
		int[] arr1 = {5,6,8,9,10,11};
		System.out.println(pivote(arr1));
		int[] arr2 = {5,1,2,3,4,6};
		System.out.println(pivote(arr2));
		int[] arr3 = {1,3,8,9,10,11};
		System.out.println(pivote(arr3));
	}
	public static int find(int[] arr, int num){
		int res = -1;
		
		return res;
	}
	
	public static int pivote(int[] arr){
		int res = -1;
		
		int start = 0;
		int end = arr.length-1;
		
		while(start <= end){
			int mid = (start+end)/2;
			if(arr[mid] > arr[0]){
				start = mid+1;
			}else if(mid == 0 && arr[mid] > arr[mid+1]){
				return mid;
			}else if(arr[mid] < arr[mid-1]){
					return mid;
			}else{
					end = mid-1;
				}
			}
		return res;
	}
	
	public static int bs(int[] arr, int start, int end, int num){
		
		while(start <= end){
			int mid = (start+end)/2;
			if(arr[mid] == num){
				return mid;
			}
			if(arr[mid] > num){
				end = mid-1;
			}else{
				start = mid+1;
			}
		}
		
		return -1;
	}
	
	
	/*
	 * [5,6,8,9,3,4]
	 * num = 6
	 * 
	 * 1: need to device the array into two parts 
	 * left 0 to pivot
	 * right pivot+1 to n
	 * 
	 * 2:first check num >= left[0] then do binary search in the left array
	 *   else do binary search in the right array 
	 * 
	 * 3: How to find this pivot point (what is pivot ? the index where array from which array is rotated)
	 * 
	 * 
	 */
	
}
