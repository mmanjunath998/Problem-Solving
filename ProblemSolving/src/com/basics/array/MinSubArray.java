package com.basics.array;

public class MinSubArray {

	public static void main(String[] args) {
		int[] arr = {1, 4, 45, 6, 0, 19};
		System.out.println("sub array length "+find(arr, 51));
	}
	
	public static int find(int[] arr, int target){
		
		int minSub = Integer.MAX_VALUE;
		int start = 0, end = 0;
		for(int i=0; i<arr.length; i++){
			
			for(int j=i; j<arr.length; j++){
				
				int sum = sum(arr, i, j+1);
				if(sum > target){
					
					if(j-i+1 < minSub){
						start = i;
						end = j;
						minSub = j-i+1;
					}
					
				}
			}
		}
		
		
		for(int i = start; i<=end; i++){
			System.out.print(" "+arr[i]);
		}
		return minSub;
		
	}
	
	public static int sum(int[] arr, int start, int end){
		int sum = 0;
		
		for(int i= start; i<end; i++){
			sum = sum + arr[i];
		}
		return sum;
	}
}
