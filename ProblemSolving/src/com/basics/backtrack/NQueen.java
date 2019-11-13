package com.basics.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueen {

	public static void main(String[] args){
		String[][] arr = new String[4][4];
		
		
		place(8);
		
	}
	
	public static void place(int n){
		int[][] arr = new int[n][n];
		solve(arr, 0);
		for(int[] ar : arr){
			for(int a : ar){
				System.out.print(a+" ");
			}
			System.out.println(" ");
		}
	}
	
	public static boolean solve(int[][] arr, int col){
		
		if(col == arr.length){
			return true;
		}
		
		for(int i=0; i<arr.length; i++){
			
			if(isSafe(arr,i,col)){
				arr[i][col] = 1;
				if(solve(arr, col+1)){
					return true;
				}else{
					arr[i][col] = 0;
				}
				
			}
		}
		return false;
	}

	private static boolean isSafe(int[][] arr, int row, int col) {
		
		//upper left diagonal
		for(int i=row, j=col; i>=0 && j>=0; i--,j--){
			
			if(arr[i][j] == 1){
				return false;
			}
		}
		
		//lower left diagonal
		for(int i=row,j=col; i<arr.length && j>=0; i++,j--){
			
			if(arr[i][j] == 1){
				return false;
			}
		}
		
		//check in the same row
		for(int i=0; i<arr.length; i++){
			if(arr[row][i] == 1){
				return false;
			}
		}
		return true;
	}
}
