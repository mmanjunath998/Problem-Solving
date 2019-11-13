package com.basics.dp;

public class MinEditDistnace {
	public static void main(String[] args) {
		String str1 = "sunday";
		String str2 = "saturday";
		System.out.println(find(str1, str2));
	}
	public static int find(String str1, String str2){
		int[][] T = new int[str1.length()+1][str2.length()+1];

		for(int i=0; i<T[0].length; i++){
			T[0][i] = i;
		}
		for(int j=0; j<T.length; j++){
			T[j][0] = j;
		}

		for(int i=1; i<T.length; i++){
			for(int j=1; j<T[0].length; j++){
				if(str1.charAt(i-1) == str2.charAt(j-1)){
					T[i][j] = T[i-1][j-1];
				}else{
					T[i][j] = 1 + Math.min(T[i][j-1], Math.min(T[i-1][j-1], T[i-1][j]));
				}
			}
		}
		return T[T.length-1][T[0].length-1];
	}
}