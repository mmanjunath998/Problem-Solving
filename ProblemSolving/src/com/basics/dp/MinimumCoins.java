package com.basics.dp;

// Minimum number of coins required to make the change of given value V;

public class MinimumCoins {

	public static int find(int[] coins, int value){
		int res = Integer.MAX_VALUE;
		int row = coins.length+1, col = value+1;
		int[][] T = new int[row][col];
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){

				if(i == 0 || j == 0 ){
					if(i == 0){
						T[i][j] = Integer.MAX_VALUE-1;		
					}else{
						T[i][j] = 0;
					}
				}else if(j >= coins[i-1]){
					if(1+T[i][j-coins[i-1]] > T[i][j]){
						T[i][j] = 1+T[i][j-coins[i-1]];
					}
				}else{
					T[i][j] = T[i-1][j];
				}
			}
		}
		
		for(int i=0; i<row; i++){
			res = Math.min(res, T[i][col-1]);
		}
		
		
		return res;
	}

	public static void main(String[] args){
		int[] coins = {1,5,6,8};
		int value = 11;
		System.out.println(find(coins, value));
	}

}
