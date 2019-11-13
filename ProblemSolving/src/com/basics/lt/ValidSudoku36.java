package com.basics.lt;

public class ValidSudoku36 {

	public static void main(String[] args){
		char[][] board = 
			{
					{'5','3','.','.','7','.','.','.','.'},
					{'6','.','.','1','9','5','.','.','.'},
					{'.','9','8','.','.','.','.','6','.'},
					{'8','.','.','.','6','.','.','.','3'},
					{'4','.','.','8','.','3','.','.','1'},
					{'7','.','.','.','2','.','.','.','6'},
					{'.','6','.','.','.','.','2','8','.'},
					{'.','.','.','4','1','9','.','.','5'},
					{'.','.','.','.','8','.','.','7','9'}
			};
		
		System.out.println(isValidSudoku(board));

	}

		public static boolean isValidSudoku(char[][] board){

			for(int i=0; i<board.length; i++){
				for(int j=0; j<board[i].length; j++){

					if(board[i][j] != '.' && !isValid(board, i, j, board[i][j])){
						return false;
					}
				}
			}

			return true;
		}

		public static boolean isValid(char[][] board, int row, int col, char num){
			//check for row
			for(int i=0; i<board[0].length; i++){
				if(i != col && board[row][i] == num){
					return false;
				}
			}

			//check for the col
			for(int i=0; i<board.length; i++){
				if(i != row && board[i][col] == num){
					return false;
				}
			}

			//check in the box
			for(int i=0; i<3; i++){
				for(int j=0; j<3; j++){

					int row1 = i+ (row-row%3);
					int col1 = j+ (col-col%3);
					if(row1 != row && col1 != col && board[row1][col1] == num){
						return false;
					}
				}
			}

			return true;
		}
	}
