package com.basics.string;

import java.util.ArrayList;
import java.util.List;

public class PalindromInString {
	public static void main(String[] args) {
		String str = "nn";
		//find(str,0,str.length());
		List<Integer> l = new ArrayList<>();
		List<Integer> r = new ArrayList<>();
		l.add(1);
		r.add(2);
		
		System.out.println(howManyPalindromes(str, l, r));
		
	}
	
	public static List<Long> howManyPalindromes(String s, List<Integer> l, List<Integer> r){
		 List<Long> result = new ArrayList<>();
         for(int k=0; k<l.size(); k++){
             int minLength = l.get(k);
             int maxLength = r.get(k);
             result.add(Long.valueOf(find(s, minLength, maxLength)));
         }
         
         return result;
	}
	
	
	
	
	public static int find(String str, int l, int r){
		int n = str.length();
		boolean[][] T = new boolean[n][n];
		int count = 0;
		for(int k=0; k<n; k++){
			for(int i=0; i<n-k; i++){
				int j = i+k;
				if(str.charAt(i) == str.charAt(j) &&  (j-i<=2 || T[i+1][j-1]) && inRange(i,j,l-1,r)){
					T[i][j] = true;
					System.out.println(str.substring(i, j+1));
					count++;
				}
			}
		}
		return count;
	}
	private static boolean inRange(int i, int j, int l, int r) {
		
		return i >= l && i<=r &&
				j>=l && j<=r;
	}
}
