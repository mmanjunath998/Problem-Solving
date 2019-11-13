package com.basics.matrix;

import java.util.ArrayList;
import java.util.List;

class Path{
	int x;
	int y;
	
	public Path(int x, int y){
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "[" + x + ", " + y + "]";
	}
}
public class FindPath {

	public static boolean find(int[][] arr, int m, int n, List<Path> path, boolean[][] visited){
	
		path.add(new Path(m, n));
		visited[m][n] = true;
		
		if(m == arr.length-1 && n == arr[0].length-1){
			for(Path p : path){
				System.out.print(p+" ");
			}
			System.out.println("...............");
			
		}
		
		if(isValid(arr, m+1, n ,visited) && find(arr, m+1, n, path, visited)){
			return true;
		}
		if(isValid(arr, m-1, n ,visited) && find(arr, m-1, n, path, visited)){
			return true;
		}
		if(isValid(arr, m, n+1 ,visited) && find(arr, m, n+1, path, visited)){
			return true;
		}
		if(isValid(arr, m, n-1 ,visited) && find(arr, m, n-1, path, visited)){
			return true;
		}
		
		path.remove(path.size()-1);
		visited[m][n] = false;
		
		
		return false;
	}

	private static boolean isValid(int[][] arr, int row, int col, boolean[][] visited) {
		
		return row>=0 && row<arr.length&&
				col>=0 && col<arr[0].length &&
				arr[row][col] == 1 &&
				!visited[row][col];
	}
	
	public static void main(String[] args){
		int[][] arr = {
				{1,0,1,0},
				{1,1,1,0},
				{0,1,1,0},
				{0,0,1,1},
		};
		
		List<Path> path = new ArrayList<Path>();
		boolean[][] visited = new boolean[arr.length][arr[0].length];
		find(arr, 0, 0, path, visited);
	}
}
