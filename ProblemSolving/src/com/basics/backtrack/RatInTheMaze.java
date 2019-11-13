package com.basics.backtrack;

import java.util.ArrayList;
import java.util.List;

public class RatInTheMaze {

	
	public static void main(String[] args){
		int[][] arr = {
				{1,1,0,0},
				{0,1,1,0},
				{1,1,1,0},
				{1,1,1,1},
		};
		List<Path> path = new ArrayList<>();
		boolean[][] visited = new boolean[arr.length][arr[1].length];
		solve(arr, 0, 0, path,visited);

	}
	
	public static boolean solve(int[][] arr, int i, int j, List<Path> path, boolean[][] visited){
		
		if(i == arr.length-1 && j == arr.length-1){
			path.add(new Path(i, j));
			visited[i][j] = true;
			printPath(path);
			path.remove(path.size()-1);
		}
		
		if(isSafe(arr,i,j,visited)){
			
			path.add(new Path(i,j));
			visited[i][j] = true;
			
			if(solve(arr, i+1, j, path,visited)){
				return true;
			}
			
			if(solve(arr, i, j+1, path,visited)){
				return true;
			}
			
			if(solve(arr, i-1, j, path,visited)){
				return true;
			}
			
			if(solve(arr, i, j-1, path,visited)){
				return true;
			}
			
			path.remove(path.size()-1);
			visited[i][j] = false;
			return false;
		}
		
		return false;
	}

	private static boolean isSafe(int[][] arr, int i, int j, boolean[][] visited) {
		
		return i>=0 && i<arr.length &&
				j>=0 && j<arr.length &&
				arr[i][j] == 1 &&
						!visited[i][j];
	}

	private static void printPath(List<Path> path) {
		path.forEach(value -> System.out.println(value.i+": "+value.j));
		System.out.println("....................");
	}
}
