package com.basics.array;

import java.util.Arrays;

public class CheckHouseStates {
	
	public static void main(String[] args){
		int[] arr = {1,0,1,1,0,1};
		
		int[] res = check(arr, 2);
		System.out.println(Arrays.toString(res));
	}

	
	public static int[] check(int[] houses, int days){
		int n = houses.length;
		System.out.println("day "+0+" : "+Arrays.toString(houses));
		for(int k=1; k<= days; k++){
			int prev = houses[0];
			int currI = 0;
			houses[0] = houses[1] == 1 ? 1: 0;	
			for(int i=1; i<n-1; i++){
				currI = houses[i];
				if(prev == houses[i+1]){
					houses[i] = 0;
				}else{
					houses[i] = 1;
				}
				prev = currI;
			}
			houses[n-1] = prev == 1 ? 1 : 0;
			
			System.out.println("day "+k+" : "+Arrays.toString(houses));
		}
		return houses;
	}
}
