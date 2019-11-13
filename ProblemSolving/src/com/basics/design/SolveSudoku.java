package com.basics.design;

public class SolveSudoku {
	
	public static void main(String[] args){
		int[][] arr = new int[][] {
			{ 0, 0, 0, 0, 0, 6, 0, 0, 0 },
			{ 0, 2, 7, 5, 1, 0, 9, 0, 8 },
			{ 3, 9, 0, 7, 0, 0, 0, 0, 5 },
			{ 0, 1, 0, 0, 0, 0, 0, 0, 0 },
			{ 9, 0, 4, 0, 0, 0, 3, 0, 6 },
			{ 0, 0, 0, 0, 0, 0, 0, 4, 0 },
			{ 5, 0, 0, 0, 0, 7, 0, 9, 4 },
			{ 8, 0, 1, 0, 6, 5, 2, 3, 0 },
			{ 0, 0, 0, 4, 0, 0, 0, 0, 0 } };
			
			SolveSudoku s = new SolveSudoku();
			s.print(arr);
			s.solve(arr);
			s.print(arr);
			
			
	}
	
	public void print(int[][] a){
		for(int[] ar : a ){
			for(int k : ar){
				System.out.print(k+" ");
			}
			System.out.println(" ");
		}
	}


	public boolean solve(int[][] arr){
		
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[0].length; j++){
				if(arr[i][j] == 0){
					for(int k=1; k<=9; k++){
						if(isSafe(arr, i, j, k)){
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

	private boolean isSafe(int[][] arr, int row, int col, int num) {
		if(row >=0 && row<arr.length &&
				col>=0 && col<arr[0].length &&
				isRowSafe(arr, row, num)  &&
				isColSafe(arr, col, num) &&
				isBoxSafe(arr, row-row%3, col-col%3, num)){
			return true;
		}
		return false;
	}
	
	private boolean isRowSafe(int[][] arr, int row, int num){
		for(int i=0; i<arr.length; i++){
			if(arr[row][i] == num){
				return false;
			}
		}
		return true;
	}
	
	private boolean isColSafe(int[][] arr, int col, int num){
		for(int i=0; i<arr.length; i++){
			if(arr[i][col] == num){
				return false;
			}
		}
		return true;
	}
	
	private boolean isBoxSafe(int[][] arr, int row,int col, int num){
		for(int i=0; i<3; i++){
			if(arr[row+i][col+i] == num){
				return false;
			}
		}
		return true;
	}
}
