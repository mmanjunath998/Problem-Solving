package com.basics.backtrack;

import java.util.ArrayList;
import java.util.List;

class Path{
	int i;
	int j;
	public Path(int i, int j){
		this.i = i;
		this.j = j;
	}
	
	public String toString(){
		return "["+i+":"+j+"]";
	}
}
public class RatInMaze {


	public static void main(String[] args){
		int[][] arr = {
				{1,1,0,0},
				{0,1,1,0},
				{1,1,1,0},
				{0,1,1,1},
		};
		List<Path> path = new ArrayList<>();
		solve(arr, 0, 0, path);
	}
	
	public static boolean solve(int[][] arr, int i, int j, List<Path> path){
		
		if(i == arr.length-1 && j == arr.length-1){
			path.add(new Path(i, j));
			printPath(path);
		}
		
		if(isSafe(arr, i, j)){
			
			path.add(new Path(i, j));
			
			if(solve(arr, i+1, j, path)){
				return true;
			}
			
			if(solve(arr, i, j+1, path)){
				return true;
			}
			
			path.remove(path.size()-1);
			return false;
		}
		return false;
	}

	private static boolean isSafe(int[][] arr, int i, int j) {
		return i>=0 && i<arr.length && j >= 0 && j<arr.length && arr[i][j] == 1;
	}

	private static void printPath(List<Path> path) {
		for(Path p : path){
			System.out.println(p.i+" : "+p.j);
		}
		System.out.println(".................");
	}
}
