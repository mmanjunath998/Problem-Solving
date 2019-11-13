package com.basics.array;

import java.util.ArrayList;
import java.util.List;

public class RiverSize {

	public static List<Integer> find(int[][] arr){
		int rows = arr.length;
		int cols = arr[0].length;
		boolean[][] visited = new boolean[rows][cols];
		
		List<Integer> res = new ArrayList<Integer>();
		
		for(int i=0; i<rows; i++){
			for(int j=0; j<cols; j++){
				int count = 1;
				if(arr[i][j] == 1 && !visited[i][j]){
					visited[i][j] = true;
					count = bfs(arr, i, j, visited,count);
					res.add(count);
				}
			}
		}
		return res;
	}
	
	public static boolean isValid(int[][] arr, int row, int col, boolean[][] visited){
		return row>=0 && row<arr.length &&
				col>=0 && col<arr[0].length &&
				arr[row][col] == 1 &&
				!visited[row][col];
	}
	
	static int[] rows = {0, 1, 0, -1};
	static int[] cols = {-1, 0, 1, 0};

	private static int bfs(int[][] arr, int row, int col, boolean[][] visited, int count) {
		
		for(int k=0; k<rows.length; k++){
			if(isValid(arr, row+rows[k], col+cols[k], visited)){
				visited[row+rows[k]][col+cols[k]] = true;
				count++;
				count = bfs(arr, (row+rows[k]), (col+cols[k]), visited, count);
			}
		}
		return count;
	}
	
	public static void main(String[] args){
		int[][] arr = {
				{1,0,0,1,0},
				{1,0,1,0,0},
				{0,0,1,0,1},
				{1,0,1,0,1},
				{1,0,1,1,0}
		};
		System.out.println(find(arr));
		
	}
	
	
}
