package com.basics.recursion;

public class GenerateValidParentheses {

	
	public static void print(String res, int open, int close, int n){
		if(open == n && close == n){
			System.out.println(res);
			return;
		}
		if(open < n){
			print(res + "(", open+1, close, n);
		}
		if(close < open){
			print(res+")", open, close+1, n);
		}
	}
	
	
	public static void main(String[] args){
		print("", 0, 0, 5);
	}
}
