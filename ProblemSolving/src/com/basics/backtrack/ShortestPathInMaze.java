package com.basics.backtrack;

public class ShortestPathInMaze {

	public static int find(int[][] maze, boolean[][] visited, int i, int j, int minDist, int dist){
		
		if(i==maze.length-1 && j==maze[0].length-1){
			return Math.min(minDist, dist);
		}
		visited[i][j] = true;
		
		if(isSafe(maze, visited, i+1, j)){
			minDist = find(maze, visited, i+1, j, minDist, dist+1);
		}
		if(isSafe(maze, visited, i-1, j)){
			minDist = find(maze, visited, i+1, j, minDist, dist+1);
		}
		if(isSafe(maze, visited, i, j-1)){
			minDist = find(maze, visited, i, j-1, minDist, dist+1);
		}
		if(isSafe(maze, visited, i,j+1)){
			minDist = find(maze, visited, i, j+1, minDist, dist+1);
		}
		visited[i][j] = false;
		return minDist;
	}
	
	public static boolean isSafe(int[][] arr, boolean[][] visited, int row, int col){
		return row>=0 && col>=0 &&
				row<arr.length && col<arr[0].length &&
				!visited[row][col] &&
				arr[row][col] != 0;		
	}
	
	public static void main(String[] args) {
		int mat[][] =
			{
					{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
					{ 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
					{ 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 },
					{ 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },
					{ 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
					{ 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 },
					{ 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
					{ 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
					{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
					{ 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 },
			};

		boolean[][] visited = new boolean[mat.length][mat.length];
		System.out.println(find(mat, visited, 0, 0, Integer.MIN_VALUE, 0));
	}
	
}

