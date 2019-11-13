package com.basics.array;
import java.util.ArrayList;
import java.util.List;

public class WaysInMatrix {

	public static void main(String[] args){
		int[][] arr = new int[2][3];
		List<Path> path = new ArrayList<>();
		System.out.println(find(arr, 0, 0, arr.length, arr.length-1, path));
	}


	public static int find(int[][] grid, int i, int j, int m, int n, List<Path> path){

		path.add(new Path(i, j));
		if(i == m && j == n){
			System.out.println(path);
			path.remove(path.size()-1);
			return 1;
		}
		if(i > m || j> n || i < 0 || j < 0){
			return 0;	
		}

		int right = find(grid, i, j+1, m,n, path);
		if(right == 0 ){
			path.remove(path.size()-1);
		}
		
		int down = find(grid,i+1, j, m,n, path);
		if(down == 0){
			path.remove(path.size()-1);
		}
		path.remove(path.size()-1);
		int r =  right+down;
		return r;

	}
}
