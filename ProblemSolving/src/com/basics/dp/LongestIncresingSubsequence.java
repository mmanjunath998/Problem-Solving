package com.basics.dp;

public class LongestIncresingSubsequence {

	public static int find(int[] a){
		int res = 0;
		int seqStart = 0;
		int n = a.length;
		int[] T = new int[n];
		int[] seq = new int[n];
		for(int i=0; i<n; i++){
			T[i] = 1;
			seq[i] = -1;
		}
		for(int i=1; i<n; i++){
			for(int j=0; j<i; j++){
				if(a[i]>=a[j] && T[j]+1 > T[i]){
					T[i] = T[j]+1;
					seq[i] = j;
					if(res < T[i]){
						res = T[i];
						seqStart = i;
					}
				}
			}
		}

		System.out.println("LIS is "+res);
		int t = seqStart;
		while(seqStart >=0){
			System.out.print(a[seqStart]+" ");
			seqStart = seq[seqStart];
		}
		System.out.println(" ");
		give(a, seq, t);
		return res;
	}

	public static int give(int[] a, int[] seq, int s){
		if(s < 0){
			return -1;
		}
		else{
			int r = a[s];
			give(a, seq, seq[s]);
			System.out.print(r+" ");
			return r;
		}

	}

	public static void main(String[] args) {
		int[] a = {5,6,3,7,8,2,1,9};
		find(a);
	}

}
