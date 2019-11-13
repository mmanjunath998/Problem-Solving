package com.basics.random;

public class GenerateValidParanthesis {

	public static void main(String[] args) {
		find(3);
	}
	public static void find(int n){
		
		print("", 0, 0, n);
	}
	
	public static void print(String res, int leftBracket, int rightBracket, int n){
		
		if(leftBracket == n && rightBracket == n){
			System.out.println(res);
		}
		if(leftBracket < n){
			print(res+"(", leftBracket+1, rightBracket, n);
		}
		if(rightBracket < leftBracket){
			print(res+")", leftBracket, rightBracket+1, n);
		}
	}
}
