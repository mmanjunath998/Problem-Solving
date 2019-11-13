package com.basics.dp;

import java.util.Arrays;

public class LongestIncreasingSubSeq {

	public static void main(String[] args){
		int[] arr = {10,22,9,33,21,50,41,60,80};
		System.out.println(find(arr));
	}
	public static int find(int[] arr){
		int res  = 0;
		int n = arr.length;
		int[] T = new int[n];
		int[] seq = new int[n];
	
		Arrays.fill(T, 1);
		
		for(int i=1; i<n; i++){
			for(int j=0; j<i; j++){
				if(arr[i] > arr[j]){
					if(T[j]+1 > T[i]){
						T[i] = T[j]+1;
						seq[i] = j;
						res = Math.max(res, T[i]);
					}
				}
			}
		}
		
		System.out.println(Arrays.toString(seq));
		
		int i = seq[n-1];
		while(i > 0){
			System.out.print(arr[i]+" ");
			i = seq[i];
		}
		
		return res;
	}
}
