package com.basics.array;

public class NthFib {

	
	public static int find(int n){
		if( n== 0 || n== 1){
			return n;
		}else{
			return find(n-1)+find(n-2);
		}
	}
	public static int findFib(int n){
		return find(n-1);
	}
	public static void main(String [] args){
		System.out.println(findFib(10));
	}
}
