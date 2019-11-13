package com.basics.backtrack;

public class NQueenPlacing {
	
	
	public static boolean solveQ(int[][] board, int row){
		
		if(row == board.length){
			print(board);
			//return true;
		}
		
		for(int col = 0; col<board[0].length; col++){
			if(isSafe(board, row, col)){
				board[row][col] = 1;
				if(solveQ(board, row+1)){
					return true; 
				}else{
					board[row][col] = 0;
				}
			}
		}
		return false;
	}
	
	public static void solve(int[][] board, int row){
		
		if(row == board.length){
			print(board);
			return;
		}
		for(int col = 0; col< board[0].length; col++){
			
			if(isSafe(board, row, col)){
				
				board[row][col] = 1;
				
				solve(board, row+1);
				
				board[row][col] = 0;   //backtrack
			}
			
		}
	}
	
	public static boolean isSafe(int[][] board, int row, int col){
		
		//check for the same column
		for(int i=0; i< row; i++){
			if(board[i][col] == 1){
				return false;
			}
		}
		
		//upper diagonal left
		for(int i=row, j=col; i>=0 && j>=0; i--,j--){
			if(board[i][j] == 1){
				return false;
			}
		}
		
		//upper diagonal right
		for(int i=row, j=col; i>=0 && j<board.length; i--, j++){
			if(board[i][j] == 1){
				return false;
			}
		}
		
		
		return true;
	}
	
	public static void print(int[][] board){
		for(int[] arr : board){
			for(int a : arr){
				System.out.print(a+" ");
			}
			System.out.println("");
		}
		System.out.println("...................");
	}
	
	public static void main(String[] args){
		int[][] board = new int[4][4];
		solve(board, 0);
		solveQ(board, 0);
	}

}
