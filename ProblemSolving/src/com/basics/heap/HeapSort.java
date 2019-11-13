package com.basics.heap;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args){
		int[] arr = {5,3,7,6,4,9,2};
		System.out.println(Arrays.toString(sort(arr)));
		
	}
	
	public static int[] sort(int[] arr){
		int n = arr.length;
		for(int i=n/2-1; i>=0; i--){
			heapify(arr, n, i);
		}
		
		for(int i=n-1; i>=0; i--){
			swap(arr, i, 0);
			heapify(arr, i, 0);
		}
		return arr;
	}
	
	//heapify ==> is build the heap : max heap
	public static void heapify(int[] arr, int n, int i){
		
		int largest = i;
		int left = 2*i+1;
		int right = 2*i+2;
		
		if(left < n && arr[left]> arr[largest]){
			largest = left;
		}
		if(right < n && arr[right] > arr[largest]){
			largest = right;
		}
		if(largest != i){
			swap(arr, i , largest);
			heapify(arr,n, largest);
		}
	}

	private static void swap(int[] arr, int i, int largest) {
		int temp = arr[i];
		arr[i] = arr[largest];
		arr[largest] = temp;
		
	}
	
}
