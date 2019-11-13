package com.basics.array;

public class SubArrayEqualsSum {

	public static void find(int[] a, int sum){
		
		int currSum = a[0], start = 0, i;
		for(i = 1; i<a.length; i++){
			
			while(currSum > sum && start < i-1){
				currSum = currSum - a[start];  //remove the trailing elements from the currSum
				start++;
			}
			
			if(currSum == sum){
				System.out.println("starting is "+start+" and ending is "+(i-1));
				break;
			}
			
			currSum = currSum + a[i];
		}
	}
	
	public static void main(String[] args){
		int[] a = {15, 2, 4, 8, 9, 5, 10, 23}; ;
		find(a, 23);
		
		
	}
}
