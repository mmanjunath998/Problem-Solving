package com.basics.array;

public class KadensAlgorithms {

	public static void find(int[] arr){
		int maxSoFar = arr[0];
		int max = arr[0];
		int start = 0, end = 0;
		for(int i=1; i<arr.length; i++){
			maxSoFar = arr[i] + maxSoFar;
			if(maxSoFar < 0){
				start = i;
				maxSoFar = 0;
			}
			if(maxSoFar > max){
				max = maxSoFar;
				end = i;
			}
		}
		System.out.println("max sum contigous sub array is "+start+" : "+end);
		System.out.println("max sum is "+max);
	}
	
	public static void main(String [] args){
		int[] arr = {-6,5,4,7,-9,8,-10};
		find(arr);
	}
}
