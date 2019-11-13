package com.basics.dp;

public class Knapsack01Problem {

	public static int find(int[] wt, int[] val, int w){
		
		int row = wt.length+1;
		int col = w+1;
		int[][] T = new int[row][col];
		int res = 0;
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				if(i == 0 || j == 0){
					T[i][j] = 0;
				}else if(j >= wt[i-1]){
					T[i][j] = Math.max(T[i-1][j], val[i-1]+T[i-1][j-wt[i-1]]);
				}else{
					T[i][j] = T[i-1][j];
				}
				
				res = T[i][j] > res ? T[i][j] : res;
			}
		}
		return res;
	}
	
	public static void main(String[] args){
		int[] val = {1,4,5,7};
		int[] wt = {1,3,4,5};
		System.out.println(find(wt, val, 7));
	}
}
