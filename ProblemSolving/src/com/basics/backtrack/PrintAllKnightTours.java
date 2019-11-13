package com.basics.backtrack;

public class PrintAllKnightTours {

	static int[] row = {2, 1, -1, -2, -2, -1,  1, 2};
	static int[] col = {1, 2,  2,  1, -1, -2, -2, -1};
	public static void solve(int[][] board, int x, int y, int pos){
		
		board[x][y] = pos;
		//our goal
		if(pos >= board.length*board.length){
			print(board);
			board[x][y] = 0;
			return;
		}
		
		//our choices
		for(int k = 0; k<row.length; k++){
			 int newX = x+row[k];
			 int newY = y+col[k];
			if(isSafe(board, newX, newY)){  //our constraints
		
				solve(board, newX, newY, pos+1);
				
				board[x][y] = 0;
			}
		}
		
		
	}
	
	public static boolean isSafe(int[][] board, int row, int col){
		return  row>=0 && col>=0 &&
				row<board.length && col<board[0].length &&
				board[row][col] == 0;
	}
	
	public static void print(int[][] board){
		for(int[] arr: board){
			for(int a : arr){
				System.out.print(a+" ");
			}
			System.out.println(" ");
		}
		System.out.println("....................");
	}
	
	public static void main(String[] args){
		int[][] board = new int[4][4];
		solve(board, 0, 0, 1);
	}
}
