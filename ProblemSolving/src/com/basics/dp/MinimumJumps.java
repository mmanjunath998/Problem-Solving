package com.basics.dp;

public class MinimumJumps {

	public static int find(int[] arr){
		
		int[] T =new int[arr.length];
		int[] seq = new int[arr.length];
		
		for(int i=1; i<arr.length; i++){
			T[i] = Integer.MAX_VALUE-1;
			seq[i] = -1;
		}
		T[0] = 0;
		seq[0] = -1;
		for(int i=1; i<arr.length; i++){
			for(int j=0; j<arr.length; j++){
				if(j+arr[j] >= i && T[j]+1 < T[i]){
					T[i] = Math.min(T[i], 1+T[j]);
					seq[i] = j;
				}
			}
		}
		System.out.print("sequences to jump : ");
		give(arr, seq, seq[arr.length-1]);
		System.out.println(" ");
		System.out.print("total jumps : ");
		return T[arr.length-1];
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
	
	public static void main(String[] args) {
		int[] arr = {1,3,5,8,9,2,6,7,6,8,9};
		System.out.println(find(arr));
	}
}
