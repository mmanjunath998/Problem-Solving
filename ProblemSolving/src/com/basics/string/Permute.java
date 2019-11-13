package com.basics.string;

import java.util.Arrays;

public class Permute {
	
	public static void main(String[] args){
		char[] arr = {'a','b','c'};
		permute(arr, 0, arr.length-1);
		int[] nums = {1,2,3};
		
	}

	public static void permute(char[] arr, int s, int n){
		
		if(s == n){
			System.out.println(Arrays.toString(arr));
		}else{
			for(int i=s; i<=n; i++){
				swap(arr, s, i);
				permute(arr,s+1, n);
				swap(arr, s, i);
			}	
		}
		
		
		
	}

	private static void swap(char[] arr, int i, int n) {
		char c = arr[i];
		arr[i] = arr[n];
		arr[n] = c;
		
	}
}
