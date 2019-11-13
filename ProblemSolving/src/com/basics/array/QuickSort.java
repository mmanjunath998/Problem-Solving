package com.basics.array;

import java.util.Arrays;

public class QuickSort {
	
	public static void main(String[] args){
		int[] arr = {8,5,1,3,9,4,7,5,4,2,3,3,4};
		System.out.println(Arrays.toString(sort(arr, 0, arr.length-1)));
	}

	public static int[] sort(int[] arr,int start, int end){
		
		if(start < end){
			int pivot = partition(arr, start, end);
			sort(arr, start, pivot-1);
			sort(arr, pivot+1, end);
		}
		return arr;
	}
	
	private static int partition(int[] arr, int l, int r){
		int x = arr[r];
		int j = l;
		int i = j-1;
		
		while(j<r){
			if(arr[j] < x){
				i = i+1;
				swap(arr,i,j);
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
