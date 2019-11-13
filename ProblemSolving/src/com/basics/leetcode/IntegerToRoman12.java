package com.basics.leetcode;

public class IntegerToRoman12 {

	public static void main(String[] args){
		System.out.println(convert(1895));
		System.out.println(convert(15));
		System.out.println(convert(195));
		System.out.println(convert(895));
		
	}
	public static String convert(int num){
		
		StringBuilder sb = new StringBuilder();
		
		int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		
		String[] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		
		for(int i=0; i<values.length; i++){
			
			while(num >= values[i]){
				sb.append(roman[i]);
				num = num - values[i];
			}
		}
		
		return sb.toString();
	}
}
