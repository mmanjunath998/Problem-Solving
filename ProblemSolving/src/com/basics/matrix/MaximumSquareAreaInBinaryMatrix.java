package com.basics.matrix;

public class MaximumSquareAreaInBinaryMatrix {
	
	public static void main(String[] args) {
		int[][] arr = {{0, 1, 1, 0, 1},  
                {1, 1, 0, 1, 0},  
                {0, 1, 1, 1, 0}, 
                {1, 1, 1, 1, 0}, 
                {1, 1, 1, 1, 1}, 
                {0, 0, 0, 0, 0}};
		
		System.out.println(find(arr));
	}
	public static int find(int[][] arr){
		int maxArea = Integer.MIN_VALUE;
		
		for(int i=1; i<arr.length; i++){
			for(int j=1; j<arr[0].length; j++){
				
				if(arr[i][j] == 1){
					arr[i][j] = Math.min(Math.min(arr[i-1][j], arr[i-1][j-1]), arr[i][j-1])+1;
					if(arr[i][j] > maxArea){
						maxArea = arr[i][j];
					}
				}
				
			}
		}
		return maxArea;
	}
}
