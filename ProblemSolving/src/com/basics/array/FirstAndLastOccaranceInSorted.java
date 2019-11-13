package com.basics.array;

public class FirstAndLastOccaranceInSorted {

	public static void main(String[] args){
		int[] arr  = {5,7,7,8,8,10};
		int x = 10;
		
		System.out.println("first"+findLeft(arr, x));
		System.out.println("right"+findRight(arr, x));
	}
	
	
	public static int findLeft(int[] arr, int x){
		int low = 0;
		int high = arr.length-1;
		while(low <= high){
			int mid = (low+high)/2;
			if(arr[mid] == x && (mid == 0 || mid-1 >= 0 && arr[mid-1] != x) ){
				return mid;
			}else if(arr[mid] == x || arr[mid] > x){
				high = mid-1;
			}else{
				low = mid+1;
			}
		}
		return -1;
	}
	
	public static int findRight(int[] arr, int x){
		int low = 0;
		int high = arr.length-1;
		while(low <= high){
			int mid = (low+high)/2;
			if(arr[mid] == x && (mid == arr.length-1 || mid+1 < arr.length && arr[mid+1] != x)){
				return mid;
			}else if(arr[mid] == x || arr[mid] < x){
				low = mid+1;
			}else{
				high = mid-1;
			}
		}
		return -1;
	}
}
