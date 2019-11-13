package com.basics.array;

public class RotateMatrix {
	
	public static void main(String[] args){
		int[][] arr = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16},
		};

		print(arr);
		rotate(arr);
		print(arr);
		
		
	}
	public static void rotate(int[][] arr){
		int n = arr.length;
		for(int i = 0; i<n/2; i++){
			for(int j=i; j<n-i-1; j++){
				int temp  = arr[i][j] ;
				arr[i][j] = arr[n-j-1][i];
				arr[n-j-1][i] = arr[n-i-1][n-j-1];
				arr[n-i-1][n-j-1] = arr[j][n-i-1];
				arr[j][n-i-1] = temp;
			}
		}
	}
	
	public static void print(int[][] arr){
		
		for(int[] ar : arr){
			for(int a : ar){
				System.out.print(a+"   ");
			}
			System.out.println(" ");
		}
		System.out.println("..................");
	}
}
