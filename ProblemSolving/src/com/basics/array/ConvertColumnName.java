package com.basics.array;

public class ConvertColumnName {

	public static void main(String[] args) {
		System.out.println(print(702));
	}
	public static String print(int n){
		
		String res = "";
		while(n > 0){
			
			int rem = n%26;
			if(rem == 0){
				res = res+'Z';
				n = n/26-1;
			}else{
				int ci = 'A'+rem-1;
				char c = (char)ci;
				res = c+res;
				n = n/26;
			}
		}
		return res;
	}
}
