package com.basics.array;

public class CheckStraightLine {
	
	public static void main(String[] args) {
		int[][] arr = {{1,1},{2,2},{3,3},{4,4},{5,5},{7,7}};
		System.out.println(isStraightLine(arr));
	}

	public static boolean isStraightLine(int[][] arr){
		
		int xSum = 0;
		int ySum = 0;
		
		for(int i=0; i<arr.length; i++){
			xSum += arr[i][0];
			ySum += arr[i][1];
		}
		return ySum-xSum <= 1;
	}
}
