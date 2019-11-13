package com.basics.array;

public class SpiralOrder {

	public static void main(String[] args){
		int[][] arr = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12}};
		spiral(arr);
	}

	
	public static void spiral(int[][] arr){
		
		
		
		int k = 0, l = 0, m = arr.length, n = arr[0].length;
		
		while(k<n && l<n){
			
			//first row
			for(int i=l; i<n; i++){
				System.out.print(arr[k][i]+" ");
			}
			k++;
			
			//last col
			for(int i=k; i<m; i++){
				System.out.print(arr[i][n-1]+" ");
			}
			n--;
			
			if(k >= m || l >= n){
				break;
			}
			//last row
			for(int i=n-1; i>=l; i--){
				System.out.print(arr[m-1][i]+" ");
			}
			m--;
			
			//first col
			
			for(int i=m-1; i>=k; i--){
				System.out.print(arr[i][l]+" ");
			}
			l++;
			
			
		}
		
		
	}
}
