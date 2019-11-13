package com.basics.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GeneratParenthesis22 {

	public static void main(String[] args){
		int n = 5;
		find("", 0, 0, n);
		
		List<String> result = new ArrayList<>();
		
		find("", n, 0, 0, result);
		System.out.println(result);
	}

	public static void find(String s, int n, int left , int right, List<String> result){
		if(left == n && right == n){
			result.add(s);
		}
		if(left > n){
			return ;
		}
		if(right > left){
			return;
		}
		
		find(s+"(", n, left+1, right, result);
		find(s+")", n, left, right+1, result);
	}

	//1 ms, faster than 93.74% of
	public static void find(String s, int left, int right , int n){
		if(left == n && right == n){
			System.out.println(s);
		}
		if(left > n){
			return ;
		}
		if(right > left){
			return;
		}
		find(s+"(", left+1, right, n);
		find(s+")", left, right+1, n);
	}
}
