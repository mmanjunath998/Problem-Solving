package com.basics.backtrack;

public class NQueenProblem {

	

	 static int n = 0;
	 
	 public static void main(String[] args){
		 n = 8;
		 int[][] arr = {
				 {0,0,0,0,0,0,0,0},
				 {0,0,0,0,0,0,0,0},
				 {0,0,0,0,0,0,0,0},
				 {0,0,0,0,0,0,0,0},
				 {0,0,0,0,0,0,0,0},
				 {0,0,0,0,0,0,0,0},
				 {0,0,0,0,0,0,0,0},
				 {0,0,0,0,0,0,0,0},
		 };
		 
		 System.out.println(solve(arr, 0));
		 
		 for(int[] ar : arr){
			 for(int a : ar){
				 System.out.print(a+" ");
			 }
			 System.out.println(" ");
		 }
	 }
	 
	 
	public static boolean solve(int[][] arr, int col){
		
		if(col>=n){
			return true;
		}
		
		for(int i=0; i<arr.length; i++){
			
			if(isSafe(arr, i, col)){
				
				arr[i][col] = 1;
				
				if(solve(arr, col+1)){
					return true;
				}

				arr[i][col] = 0;
			}
		}
		return false;
	}
	
	
	public static boolean isSafe(int[][] arr, int row, int col){
		
		//check the same row
		for(int i=0; i<col; i++){
			if(arr[row][i] == 1){
				return false;
			}
		}
		
		//check upper left diagonal
		for(int i=row, j= col; i>=0 && j>=0; i--,j--){
			if(arr[i][j] == 1){
				return false;
			}
		}

		//check lower left diagonal
		for(int i=row, j= col; i<arr.length && j>=0; i++,j--){
			if(arr[i][j] == 1){
				return false;
			}
		}
		return true;
	}
	

}
