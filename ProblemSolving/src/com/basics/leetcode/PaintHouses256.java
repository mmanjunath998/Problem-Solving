package com.basics.leetcode;

public class PaintHouses256 {
	
	public static void main(String[] args){
		int[][] costs = {
				{10,2,15},
				{6,13,14},
				{8,7,9},};
		
		System.out.println(paintHouses(costs));
	}
	
	
	public static int paintHouses(int[][] cost){
		
		if(cost == null || cost.length == 0){
			return 0;
		}
		
		for(int i = 1; i<cost.length; i++){
			
			cost[i][0] += Math.min(cost[i-1][1], cost[i-1][2]);
			cost[i][1] += Math.min(cost[i-1][0], cost[i-1][2]);
			cost[i][2] += Math.min(cost[i-1][0], cost[i-1][1]);
		}
		
		return Math.min(Math.min(cost[cost.length-1][0], cost[cost.length-1][1]), cost[cost.length-1][2]);
	}
}
