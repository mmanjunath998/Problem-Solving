package com.basics.backtrack;

public class NumberOfWaysRatCanMove {

	static int count  = 0;
	
	public static void main(String[] args){
		int[][] arr = {
				{1,1,0,0},
				{0,1,1,0},
				{1,1,1,0},
				{1,1,1,1},
		};
		boolean[][] visited = new boolean[arr.length][arr[1].length];
		System.out.println(solve(arr, 0, 0, visited));
		System.out.println(count);
	}
	

	
	
	public static boolean solve(int[][] arr, int i, int j, boolean[][] visited){
		
		if(i == arr.length-1 && j == arr.length-1){
			count++;
			visited[i][j] = true;
		}
		
		if(isSafe(arr, i, j, visited)){
			
			visited[i][j] = true;
			if(solve(arr, i+1, j, visited)){
				return true;
			}
			if(solve(arr, i-1, j, visited)){
				return true;
			}
			if(solve(arr, i, j+1, visited)){
				return true;
			}
			if(solve(arr, i, j-1, visited)){
				return true;
			}
			visited[i][j] = false;
			return false;
		}
		
		return false;
	}
	private static boolean isSafe(int[][] arr, int i, int j, boolean[][] visited) {

		return i>=0 && i<arr.length &&
				j>= 0 && j<arr.length &&
				arr[i][j] == 1 &&
				!visited[i][j];
	}
}
