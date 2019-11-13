package com.basics.recursion;

public class DeviceTheNumbeByFourParts {
	
	public static void main(String[] args){
		print(1,1,1,1, 8);
	}

	public static void print(int n1, int n2, int n3, int n4, int n){
		int sum = sum(n1,n2,n3,n4);
		if(sum == n){
			System.out.println(n1+","+n2+","+n3+","+n4);
			return;
		}
		if(sum > n){
			return;
		}
		//
		print(n1+1, n2, n3, n4, n);
		print(n1+1, n2+1, n3, n4, n);
		print(n1+1, n2, n3+1, n4, n);
		print(n1+1, n2, n3, n4+1, n);

	}
	
	
	public static int sum(int n1, int n2, int n3, int n4){
		int r = 0;
		r = n1 + n2 + n3 + n4;
		return r;
	}
}
