package com.basics.array;

import java.util.HashMap;
import java.util.Map;

public class FindSubArrayForTarget {

	public static void main(String[] args) {
		 int[] arr = {15, 2, 4, 8, 9, 5, 10, 23}; 
		 find(arr, 23);
		 findOn(arr, 23);
		 findn(arr, 23);
		 
		
	}
	
	
	public static void findn(int[] arr, int sum){
		
		int currSum = 0;
		int start = 0;
		int end = 0;
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i=0; i<arr.length; i++){
			currSum = currSum + arr[i];
			
			if(map.containsKey(currSum - sum)){
				start = map.get(currSum - sum)+1;
				end = i;
				break;
			}
			
			map.put(currSum, i);
		}
		
		for(int i= start; i<=end; i++){
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void findOn(int[] arr, int sum){
		int currSum = 0;
		int start = 0;
		currSum = arr[0];
		for(int i=1; i<arr.length; i++){
			
			while(currSum > sum && start < i){
				currSum = currSum - arr[start];
				start++;
			}
			
			if(currSum == sum){
				System.out.println("found sub array at "+start+" to "+(i-1));
			}
			
			if(i < arr.length){
				currSum = currSum + arr[i];
			}
			
		}
	}
	
	
	
	public static void find(int[] arr, int sum){
		
		int currSum = 0;
		
		for(int i = 0; i<arr.length; i++){
			
			currSum = arr[i];
			for(int j = i+1; j<arr.length; j++){
				
				if(currSum == sum){
					System.out.println("found sub arry : "+i+" to "+(j-1));
				}
				if(currSum > sum){
					break;
				}
				
				currSum = currSum + arr[j];
			}
		}
	}
}
