package com.basics.array;

public class MissingNumber {

	public static void find(int[] arr){
		int res = 0;
		int res1 = 0;
		for(int i=1; i<16; i++){
			res1 = res1^i;
		}
		
		for(int i=0; i<arr.length; i++){
			res = res ^ arr[i];
		}
		System.out.println(res^res1);
	}
	
	public static void main(String[] args){
		int[] arr = {1,2,3,4,15,8,5,9,10,6,12,7,11,14};
		find(arr);
	}
}

