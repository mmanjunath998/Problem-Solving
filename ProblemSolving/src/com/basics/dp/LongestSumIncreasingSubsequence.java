package com.basics.dp;

public class LongestSumIncreasingSubsequence {
	
	public static void main(String[] args){
		int[] arr = {1,101,2,3,100,4,5};
		int r = find(arr);
		
		System.out.println(r);
		
	}

	public static int find(int[] arr){
		int res = 0;
		int[] T = new int[arr.length];
		int[] seq = new int[arr.length];
		for(int i=0; i<arr.length; i++){
			T[i] = arr[i];
			seq[i] = -1;
		}
		int start = 0;
		
		for(int i=1; i<arr.length; i++){
			for(int j=0; j<i; j++){
				if(arr[i] > arr[j] ){
					T[i] = Math.max(T[i], T[j]+arr[i]);
					seq[i] = j;
					start = i;
					res = T[i] > res ? T[i] : res;
				}
			}
		}
		give(arr, seq, start);
		System.out.println("");
		return res;
	}
	
	public static int give(int[] arr, int[] seq, int s){
		if(s < 0){
			return -1;
		}else{
			int r = arr[s];
			s = seq[s];
			give(arr, seq, s);
			System.out.print(r+" ");
			return r;
		}
	}
}
