package com.basics.array;

public class DevideNumber {

	public static void main(String[] args){
		int dividend = -2147483648;
		int divisor = 1;
		System.out.println(divide(dividend, divisor));
	}
	 public static  int divide(long dividend, long divisor) {
	        boolean isNegative = false;
	        if(dividend < 0 && divisor < 0){
	            dividend = -dividend;
	            divisor = -divisor;
	        }else if(dividend < 0 ){
	            dividend = -dividend;
	            isNegative = true;
	        }else if(divisor < 0){
	            divisor = -divisor;
	            isNegative = true;
	        }
	        
	        long count = 0;
	        while(dividend >= divisor){
	            count++;
	            if(count >= Integer.MAX_VALUE){
	                return isNegative ? -1*Integer.MAX_VALUE : Integer.MAX_VALUE;
	            }
	            dividend -= divisor;
	        }
	        
	        return isNegative ? (int)-count : (int)count;
	    }
}
