package com.basics.array;

public class FindInSortedButRotated {

	public static void main(String[] args) {
		int[] arr = {5,6,7,8,9,10,1,2,3};
		System.out.println(find(arr, 9));
	}
	public static int find(int[] arr, int x){
		int n = arr.length;
		int mid = mid(arr);
		int low = mid+1;
		int high = mid;
		while(low != high){
			int m = (low+high)/2;
			if(arr[m] == x){
				return m;
			}else if(arr[m] > x){
				high = (n+high-1)%n;
			}else{
				low = (low+1)%n;
			}
		}
		return -1;
	}
	
	public static int mid(int[] arr){
		int low = 0;
		int high = arr.length-1;
		while(low <= high){
			int mid = (low+high)/2;
			if(arr[mid] < arr[mid+1]){
				if(arr[mid] > arr[0]){
					low = mid+1;
				}else{
					high = high-1;
				}
			}else{
				return mid;
			}
		}
		return -1;
	}
}
