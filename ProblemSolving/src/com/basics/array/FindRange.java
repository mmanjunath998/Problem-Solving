package com.basics.array;

public class FindRange {

	public static void find(int[] arr, int sum ){
		int start = 0; 
		int currSum = arr[0];
		for(int i=1; i<arr.length; i++){
			while(currSum > sum && start <i-1){
				currSum = currSum - arr[start];
				start = start+1;
			}
			
			if(currSum == sum){
				System.out.println("positions are "+start+" : "+(i-1));
			}
			currSum = currSum + arr[i];
		}
	}
	
	public static void main(String[] args){
		int[] arr = {4,2,7,5,1,8,6,9};
		find(arr, 20);
		
	}
}
