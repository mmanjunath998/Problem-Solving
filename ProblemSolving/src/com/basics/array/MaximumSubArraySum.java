package com.basics.array;

import java.util.HashMap;
import java.util.Map;

public class MaximumSubArraySum {

	public static void main(String[] args) {
		int[] arr = {-5, 8, -14, 2, 4, 12};
		int k = -5;
		findNaiveOn3(arr, k);
		findOn2(arr, k);
		findOn(arr, k);
	}
	
	
	public static void findNaiveOn3(int[] arr, int s){
		int len = 0;
		int endingIndex = 0;
		for(int i=0; i<arr.length; i++){
			for(int j=i; j<arr.length; j++){
				int sum = 0;
				for(int k = i; k<=j; k++){
					sum +=  arr[k];
				}
				if(sum == s && j-i+1 > len){
					len = j-i+1;
					endingIndex = j;
				}
				
			}
		}
		
		System.out.println("max subarray starts at "+(endingIndex-len+1)+" and ends at "+endingIndex);
	}
	

	public static void findOn2(int[] arr, int s){
		
		int len = 0, endingIndex = 0;
		for(int i=0; i<arr.length; i++){
			int sum = 0;  // try for all the sub array starting from i
			for(int j=i; j<arr.length; j++){
				sum = sum + arr[j];
				if(sum == s && len < j-i+1){
					len = j-i+1;
					endingIndex = j;
				}
			}
		}
		System.out.println("max subarray starts at "+(endingIndex-len+1)+" and ends at "+endingIndex);
	}
	
	
	public static void findOn(int[] arr, int s){
		
		int len = 0, endingIndex = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int sum = 0;
		map.put(0, -1);
		
		for(int i=0; i<arr.length; i++){
			sum = sum + arr[i];
			if(!map.containsKey(sum)){
				map.put(sum, i);
			}
			
			if(map.containsKey(sum-s) && len < i-map.get(sum-s)){
				len = i-map.get(sum-s);
				endingIndex  = i;
			}
		}
		System.out.println("max subarray starts at "+(endingIndex-len+1)+" and ends at "+endingIndex);
	}
}
