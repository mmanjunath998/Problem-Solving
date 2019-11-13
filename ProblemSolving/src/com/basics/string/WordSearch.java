package com.basics.string;

public class WordSearch {

	public static void main(String[] args){
		String word = "AAB";
		char[][] board = 
				{
				{'C','A','A'},
				{'A','A','A'},
				{'B','C','D'}};
						
		
		
		char[][] board1 = {
				{'a','a'},
		};
		
		System.out.println(search(board, word));
	}

	public static boolean search(char[][] board, String word){
		
		boolean[][] visited = new boolean[board.length][board[0].length];
		
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[i].length; j++){
				
				if(board[i][j] == word.charAt(0)){
					visited[i][j] = true;
					if(dfs(board, word, i, j, 1, visited)){
						return true;
					}else{
						visited[i][j] = false;
					}
				}
			}
		}
		
		return false;
	}
	
	public static boolean dfs(char[][] board, String word, int i, int j, int len,boolean[][] visited){
		
		if(len == word.length()){  //goal
			return true;
		}
		
		
		int[] row = {1,-1,0,0};
		int[] col = {0,0,1,-1};
		
		for(int k = 0; k<row.length; k++){  //choises
			int row1 = i+row[k];
			int col1 = j+col[k];
			if(isValid(board, word, i, len, visited, row1, col1)){
				visited[row1][col1] = true;
				if(dfs(board, word, row1, col1, len+1, visited)){
					return true;
				}
				visited[row1][col1] = false;
			}
		}
		return false;
	}

	private static boolean isValid(char[][] board, String word, int i, int len, boolean[][] visited, int row1,
			int col1) {
		return row1 >= 0 && row1 < board.length && col1 >= 0 && col1<board[i].length && board[row1][col1] == word.charAt(len) && !visited[row1][col1];
	}
	
	
	
}
