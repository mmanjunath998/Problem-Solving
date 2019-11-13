package com.basics.array;

import java.util.Map;

public class PowerOfNumber {

	public static void main(String[] args){

		System.out.println(-8%3);

		double a = 34.00515;
		int b = -3;
		System.out.println(power(a,b));
		System.out.println(Math.pow(a, b));
		System.out.println(pow(a, b));

	}

	public static double pow(double a, int b){

		if(b == 1 || b == 0 || b == -1){

			if(b > 0){
				return a;
			}else{
				return 1/a;
			}
		}


		if(b % 2 == 0){
			return pow(a, b/2) * pow(a,b/2);
		}else{

			if(b < 0){
				return 1/a * pow(a, b/2) * pow(a , b/2);	
			}else{
				return a * pow(a, b/2) * pow(a , b/2);
			}

		}
	}
	
	 public double myPowN(double x, int n, Map<String, Double> map) {
	        if(n == 0){
	            return 1;
	        }
	        
	        if(n == 1 || n == -1){
	            if(n < 0){
	                return 1/x;    
	            }else{
	                return x;
	            }
	            
	        }
	         String key =  x +"|"+n;
	         
	         if(map.containsKey(key)){
	             return map.get(key);
	         }else{
	             double res = 1.0;
	             if(n % 2 == 0){
	             res = myPowN(x, n/2,map) * myPowN(x, n/2,map);            
	             }else{
	                if(n > 0){
	                     res =  x * myPowN(x, n/2,map) * myPowN(x, n/2,map);    
	                 }else{
	                     res =  1/x * myPowN(x, n/2,map) * myPowN(x, n/2,map);
	            }
	             map.put(key, res);
	                 return map.get(key);
	            }
	         }
	         return -1;
	    }

	public static double power(double a, int b){
		double res = 1;

		for(int i=1; i<= Math.abs(b); i++){

			if(b > 0){
				res = res * a;
			}else{
				res = (double)res/a;
			}
		}

		return res;
	}
}
