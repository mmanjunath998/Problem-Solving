package com.basics.array;

public class QuickSelect {
	public static void main(String[] args) {
		int[] arr = {8,5,1,3,9};
		System.out.println(findKthLargest(arr, 9));
	}

	public static int findKthLargest(int[] arr, int k){
		
		return find(arr, 0, arr.length-1, k);
	}
	
	private static int find(int[] arr, int start, int end, int k){
		
		if(start <= end){
			
			int partition = partition(arr, start, end);
			if(partition+1 == k){
				return arr[partition];
			}else if(partition < k){
				return find(arr, partition+1, end, k);
			}else{
				return find(arr, start, partition-1,k);
			}
		}
		return -1;
	}
	
	private static int partition(int[] arr, int l, int r){
		int x = arr[r];
		int j = l;
		int i = j-1;
		while(j < r){
			if(arr[j] > x){
				i = i+1;
				swap(arr, i,j);
			}
			j++;
		}
		swap(arr, i+1, r);
		return i+1;
	}
	
	private static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
}
