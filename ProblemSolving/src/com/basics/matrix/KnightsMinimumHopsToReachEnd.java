package com.basics.matrix;

import java.util.LinkedList;
import java.util.Queue;

class Cell{
	int x;
	int y;
	int dist;
	public Cell(int x, int y, int dist){
		this.x = x;
		this.y = y;
		this.dist = dist;
		
	}
}
public class KnightsMinimumHopsToReachEnd {
	
	public static void main(String[] args) {
		System.out.println(find(7, 0, 5, 1, 8));
	}
	
	
	public static int find(int xStart, int yStart, int xEnd, int yEnd, int n){
		
		int[][] board = new int[n][n];
		boolean[][] visited = new boolean[n][n];
		Queue<Cell> q = new LinkedList<Cell>();
		q.add(new Cell(xStart, yStart, 0));
		
		int[] rows = {2, 2, -2, -2, 1, -1, 1,-1};
		int[] cols = {1,-1,  1, -1, 2, 2, -2,-2};
		
		while(!q.isEmpty()){
			
			Cell cell = q.poll();
			if(cell.x == xEnd && cell.y == yEnd){
				return cell.dist;
			}
			
			for(int k=0; k<rows.length; k++){
				int x = cell.x + rows[k];
				int y = cell.y + cols[k];
				if(isInside(board, x, y) && !visited[x][y]){
					visited[x][y] = true;
					q.add(new Cell(x, y, cell.dist+1));
				}
			}
			
		}
		return 1;
	}
	
	private static boolean isInside(int[][] arr, int row, int col){
		return row>=0 && row<arr.length &&
				col>=0 && col<arr[0].length;
	}
}
