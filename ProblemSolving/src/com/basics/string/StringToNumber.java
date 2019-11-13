package com.basics.string;

public class StringToNumber {
public static void main(String[] args) {
	String s ="-+1";
	System.out.println(convert(s));
}
	
	public static int convert(String str){
		if(str == null || str.length()==0){
			return 0;
		}
		
		int sign = 1;
		long base = 0;
		char[] arr = str.toCharArray();
		int i = 0;
		
		//remove the white spaces
		while(i < arr.length && arr[i] == ' '){
			i++;
		}
		
		if(i < arr.length && arr[i] == '+'){
			i++;
		}
		if(i < arr.length && arr[i] == '-'){
			sign = -1;
			i++;
		}
		
		while(i < arr.length && arr[i] >= '0' && arr[i] <= '9'){
			base = base*10 + arr[i]-'0';
			
			if(sign * base > Integer.MAX_VALUE){
				return Integer.MAX_VALUE;
			}
			if(sign * base < Integer.MIN_VALUE){
				return Integer.MIN_VALUE; 
			}
			i++;
		}
		return (int)(sign*base);
		
	}
}
