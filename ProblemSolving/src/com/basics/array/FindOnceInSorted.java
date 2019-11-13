package com.basics.array;

// 1 1 2 2 3 3 4 5 5 6 6 7 7
// 0 1 2 3 4 5 6 7 8 9 10 11 12
public class FindOnceInSorted {
	
	public static void main(String[] args) {
		int[] arr = {1,1,2,3,3,4,4,5,5,6,6,7,7};
		System.out.println(find(arr));
	}

	public static int find(int[] arr){
		int low = 0;
		int high = arr.length-1;
		int res = 0;
		
		while( low<= high){
			int mid = (low+high)/2;
			if(mid % 2 == 0){
				if(arr[mid] == arr[mid+1]){
					low = mid+1;
				}else if(arr[mid] != arr[mid-1]){
					return arr[mid];
				}else{
					high = high-1;
				}
			}else{
				if(arr[mid] == arr[mid-1]){
					low = mid+1;
				}else if(arr[mid] != arr[mid+1]){
					return arr[mid];
				}else{
					high = high-1;
				}
			}
		}
		
		
		return res;
	}
}
