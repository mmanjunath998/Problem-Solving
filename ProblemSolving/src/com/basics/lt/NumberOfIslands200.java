package com.basics.lt;

public class NumberOfIslands200 {

	public static void main(String[] args){
		char[][] grid = {
						{'1','1','0','1','0'},
						{'1','1','0','1','0'},
						{'0','0','0','0','0'},
						{'1','0','1','1','0'}
		};
		System.out.println(find(grid));
	}
	
	
	
	
	public static int find(char[][] grid){
		
		int numberOfIslands = 0;
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[i].length; j++){
				
				if(grid[i][j] == '1'){
					numberOfIslands++;
					dfs(grid, i, j);
				}
			}
		}
		return numberOfIslands;
	}
	
	public static void dfs(char[][] grid, int i, int j){
		
		//check the edges
		if(i < 0 || i >= grid.length){
			return;
		}
		
		if(j < 0 || j >= grid[i].length){
			return;
		}
		if(grid[i][j] == '0'){
			return ;
		}
		
		grid[i][j] = '0';
		dfs(grid, i+1, j); //down
		dfs(grid, i-1, j); //top
		dfs(grid, i, j+1); //right
		dfs(grid, i, j-1); //left
		
		return;
	}
}
