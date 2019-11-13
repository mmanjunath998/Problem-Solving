package com.basics.array;

public class MarkAllOnes {

	public static void main(String[] args) {
		int[][] arr = {
				{0,0,0,1,0},
				{0,0,0,0,0},
				{0,0,0,0,0},
				{1,0,0,0,1},
				{0,1,0,1,0}
		};
		
		int[][] arr1 = {{1,0,0,1},{0,0,1,0},{0,0,0,0}};
		print(arr1);
		find(arr1);
		print(arr1);
	}
	
	public static void find(int[][] arr){
		int row = arr.length;
		int col = arr[0].length;
		boolean[][] visited = new boolean[row][col];
		
		for(int i=0; i<row; i++){
			for(int j= 0; j<col; j++){
				if(arr[i][j] == 1 && !visited[i][j]){
					visitNeighbour(arr, visited, i, j);
					print(arr);
				}
			}
		}
	}
	
	public static void print(int[][] arr){
		for(int i=0; i<arr.length; i++){
			for(int j = 0; j<arr[0].length; j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println(" ");
		}
		System.out.println(".............");
	}
	
	public static void visitNeighbour(int[][] arr, boolean[][] visited, int row, int col){
		
		for(int i=0; i<arr[0].length; i++){
			if(arr[row][i] == 0 && !visited[row][i]){
				arr[row][i] = 1;
				visited[row][i] = true;
			}
		}
		for(int i=0; i<arr.length; i++){
			if(arr[i][col] == 0 && !visited[i][col]){
				arr[i][col] = 1;
				visited[i][col] = true;
			}
		}
	}
}
