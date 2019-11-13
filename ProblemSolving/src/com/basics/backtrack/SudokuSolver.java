package com.basics.backtrack;

public class SudokuSolver {

	
	public static void main(String[] args){
		 int[][] board = new int[][] 
				    { 
				            {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
				            {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
				            {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
				            {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
				            {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
				            {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
				            {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
				            {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
				            {0, 0, 5, 2, 0, 6, 3, 3, 0} 
				    }; 
		
		print(board);
		System.out.println(solve(board));
		print(board);
	}
	
	public static  void print(int[][] arr){
		for(int[] ar : arr){
			for(int a : ar){
				System.out.print(a+" ");
			}
			System.out.println(" ");
		}
	}
	
	public static boolean solve(int[][] arr){
		
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[0].length; j++){
				if(arr[i][j] == 0){ 
					for(int k=1; k<10; k++){
						if(isOk(arr,i,j,k)){
							arr[i][j] = k;
							if(solve(arr)){
								return true;
							}else{
								arr[i][j] = 0;
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isOk(int[][] arr, int i, int j, int k) {
		return isRowOk(arr, i, k) &&
				isColOk(arr, j, k) &&
				isBoxOk(arr,i-i%3,j-j%3,k);
	}

	private static boolean isBoxOk(int[][] arr, int row, int col, int k) {
		
		for(int i=0; i<3; i++){
			if(arr[i+row][i+col] == k){
				return false;
			}
		}
		return true;
	}

	private static boolean isColOk(int[][] arr, int col, int k) {

		for(int i=0; i<arr[1].length; i++){
			if(arr[i][col] == k){
				return false;
			}
		}
		return true;
	}

	private static boolean isRowOk(int[][] arr, int row, int k) {
		for(int i=0; i<9; i++){
			if(arr[row][i] == k){
				return false;
			}
		}
		return true;
	}
}