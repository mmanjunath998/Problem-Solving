package com.basics.matrix;

public class SpiralTraversal {

	public static void main(String[] args){
		int[][] arr = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};
		printArray(arr);
		print(arr);
		
		
	}
	public static void printArray(int[][] arr){
		for(int[] ar : arr){
			for(int a : ar){
				System.out.print(a+"  ");
			}
			System.out.println(" ");
		}
		
		System.out.println(" ");
	}
	
	public static void print(int[][] arr){
		int k=0;  //first row
		int l=0;  //first column
		int m = arr.length; //last row
		int n = arr[0].length; //last column;
		int i=0; //used to traverse 
		
		while(k < m && l<n){
			
			//first row
			for( i=l; i<n; i++){
				System.out.print(arr[k][i]+" ");
			}
			k++;
			
			//last col
			for(i=k; i<m; i++){
				System.out.print(arr[i][n-1]+" ");
			}
			n--;
			
			//last row
			for(i = n-1; i>=l; i--){
				System.out.print(arr[m-1][i]+" ");
			}
			m--;
			
			//first col
			for(i = m-1; i>=k; i--){
				System.out.print(arr[i][l]+" ");
			}
			l++;
		}
		
	}
}
