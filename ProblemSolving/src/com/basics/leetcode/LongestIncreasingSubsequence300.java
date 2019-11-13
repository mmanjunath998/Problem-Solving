package com.basics.leetcode;

import java.util.Arrays;

public class LongestIncreasingSubsequence300 {

	public static void main(String[] args){
	
		int[] arr = {6,4,7,2,3,10,5,8,1,3,7,10,12};
		findLIS(arr);
		System.out.println("");
		LIS(arr);
		System.out.println(find(arr));
	}
	
	
	/*
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Longest Increasing Subsequence.
	 */
	
	public static int find(int[] arr){
		int n = arr.length, len = 0;
		int[] increasingSequence = new int[n];
		increasingSequence[len++] = arr[0];
		
		for(int i=1; i<n; i++){
			
			if(arr[i] > increasingSequence[len-1]){
				increasingSequence[len++] = arr[i];
			}else{
				int position = findPositionToReplace(increasingSequence, 0, len-1, arr[i]);
				increasingSequence[position] = arr[i];
			}
		}
		System.out.println(Arrays.toString(increasingSequence));
		return len;
		
	}
	
	public static int findPositionToReplace(int[] arr, int low , int high, int x){
		
		while(low <= high){
			int mid = (low+high)/2;
			if(arr[mid] == x){
				return mid;
			}
			if(arr[mid] > x){
				high = mid - 1;
			}else{
				low = mid + 1;
			}
		}
		return low;
	}
	
	public static void LIS(int[] arr){
		int n = arr.length, max = 0;
		int[] dp = new int[n];
		
		for(int i=0; i<n; i++){
			dp[i] = 1;
			
			for(int j=0; j<i; j++){
				if(arr[i] > arr[j] && dp[j]+1 > dp[i]){
					dp[i] = dp[j]+1;
					max= Math.max(max, dp[i]);
				}
			}
		}
		System.out.println("LIS size is "+max);
	}
	

	public static void findLIS(int[] arr){
		
		int n = arr.length;
		int[] T = new int[n];
		int[] seq = new int[n];
		int size = 0;
		int start = 0;
		for(int i=0; i<n; i++){
			T[i] = 1;
			for(int j=0; j<i; j++){
				
				if(arr[j] < arr[i]){
					
					if(T[j]+1 > T[i]){
						
						T[i] = T[j]+1;
						seq[i] = j;
						if(size < T[i]){
							size = T[i];
							start = i;
						}
					}
				}
			}
		}
		
		System.out.println("LIS size is "+size);
		
		while(start >= 0){
			System.out.print(arr[start]+" ");
			if(start == 0){
				break;
			}
			start = seq[start];
		}
	}
}
