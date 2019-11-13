package com.basics.array;

public class PowerNumber {
	
	public static void main(String[] args){
		System.out.println(pow(2, 4));
		System.out.println(pow(2, -4));
		System.out.println(pow(-2, 4));
		System.out.println(pow(-2, -4));
		System.out.println(pow(-3, 3));
	}

	public static double pow(double x, int n){
		
		boolean isNegativeN = n < 0 ? true: false;
		
		n = isNegativeN ? -n : n;
		
		double res = power(x, n);
		
		if(isNegativeN){
			return 1/res;
		}
		return res;
	}
	
	public static double power(double x, int n){
		if( n == 0){
			return 1;
		}
		if(n == 1){
			return x;
		}
		if(n % 2 != 0){
			return x * power(x, n-1);
		}else{
			return power(x, n/2)* power(x, n/2);
		}
	}
}
