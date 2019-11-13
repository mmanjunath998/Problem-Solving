package com.basics.matrix;

public class RotateMatrix {
	
	public static void main(String[] args){
		int[][] arr = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};
		
		print(arr);
		rotate(arr);
		print(arr);
		
	}
	
	public static void print(int[][] arr){
		for(int[] ar : arr){
			for(int a : ar){
				System.out.print(a+"  ");
			}
			System.out.println(" ");
		}
		
		System.out.println(" ");
	}

	public static void rotate(int[][] arr){
		int k=0; // row start
		int l=0; //col start
		int m=arr.length; //row end;
		int n=arr[0].length; //col end
		int i=0;  //traversal
		
		int curr = 0, prev = 0;
		
		while(k<m && l<n){
			
			
			if(k+1 == m || l+1 == n){
				break;
			}
			
			 prev = arr[k+1][l];
			//first row
			for(i=l; i<n; i++){
				curr = arr[i][k];
				arr[i][k] = prev;
				prev = curr;
			}
			k++;
			
			//last col
			for(i=k; i<m; i++){
				curr = arr[i][n-1];
				arr[i][n-1] = prev;
				prev = curr;
			}
			n--;
			
			//last row
			for(i=n-1; i>=l; i--){
				curr = arr[m-1][i];
				arr[m-1][i] = prev;
				prev = curr;
			}
			m--;
			
			//first col
			for(i=m-1; i>=k; i--){
				curr = arr[i][l];
				arr[i][l] = prev;
				prev = curr;
			}
			l++;
		}
	}
}
