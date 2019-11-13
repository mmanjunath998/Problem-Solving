package com.basics.lt;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray26 {

	public static void main(String[] args){
		int[] arr = {0,0,1,1,1,2,2,3,3,4};
		System.out.println(Arrays.toString(removeDuplicates(arr)));
	}
	public static int[] removeDuplicates(int[] arr){
		
		int start = 1;
		for(int i=0; i<arr.length-1; i++){
			
			if(arr[i] != arr[i+1]){
				arr[start++] = arr[i+1];
			}
		}
		
		return arr;
	}
}
