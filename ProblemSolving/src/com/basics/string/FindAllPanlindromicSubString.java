package com.basics.string;

import java.util.ArrayList;
import java.util.List;

public class FindAllPanlindromicSubString {

	public static void main(String[] args) {
		String str = "abccbccddccbccba";
		System.out.println(findAll(str));
		
	}
	public static List<String> findAll(String str){
		List<String> res = new ArrayList<String>();
		int n = str.length();
		boolean[][] T = new boolean[n][n];
		for(int k=0; k<n; k++){
			for(int i=0; i<n-k; i++){
				int j = i+k;
				if(str.charAt(i) == str.charAt(j) && (j-i <= 1 || T[i+1][j-1])){
					T[i][j] = true;
					res.add(str.substring(i, j+1));
				}
			}
		}
		return res;
	}
}
