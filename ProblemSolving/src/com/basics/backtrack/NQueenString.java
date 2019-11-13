package com.basics.backtrack;

import java.util.ArrayList;
import java.util.List;

public class NQueenString {
	
	public static void main(String[] args) {
		place(4);
	}

	public static void place(int n){
		int[][] arr= new int[n][n];
		solve(arr, 0);
		List<List<String>> convert = convert(arr);
		
		for(List<String> list : convert){
			System.out.println(list);
		}
		
		
	}
	public static List<List<String>> convert(int[][] arr){
		List<List<String>> lists = new ArrayList<>();
		
		for(int i=0; i<arr.length; i++){
			
			List<String> list = new ArrayList<>();
			for(int j = 0; j<arr[0].length; j++){
				if(arr[i][j] == 1){
					list.add("Q");
				}else{
					list.add(".");
				}
			}
			lists.add(list);
		}
		return lists;
	}
	
	public static void fill(List<String> list, int n){
		
		for(int i=0; i<n; i++){
			list.add(".");
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
		
		//check for upper left diagonal
		for(int i=row, j= col; i>=0 && j>=0; i--,j--){
			if(arr[i][j] == 1){
				return false;
			}
		}
		
		//check for the lower left diagonal
		for(int i=row,j=col; i<arr.length && j>=0; i++, j--){
			if(arr[i][j] == 1){
				return false;
			}
		}
		
		for(int i=0; i<arr.length; i++){
			if(arr[row][i] == 1){
				return false;
			}
		}
		
		return true;
	}
}
