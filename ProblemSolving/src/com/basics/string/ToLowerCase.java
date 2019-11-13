package com.basics.string;

public class ToLowerCase {

	public static void main(String[] args){
		int i = 'A';
		int b = 'Z';
		System.out.println(i);
		System.out.println(b);
		int i1 = 'a';
		int b2 = 'z';
		System.out.println(i1);
		System.out.println(b2);
		
		int k = 97;
		System.out.println((char)k);
		
		System.out.println(find("hellO"));
		System.out.println(find("MANJUNATH"));
		System.out.println(find("PraTyUsH"));
		System.out.println(find("aY&$HU"));
		System.out.println(find("$Ha$hI"));
		
	}
	
	
	public static String find(String str){
		String res = "";
		for(int i=0; i<str.length(); i++){
			char c = str.charAt(i);
			if(c >= 97 && c<= 122){
				res = res + c;
			}else if(c >= 65 && c<= 90){
				int cVal = c + 32;
				res = res + (char)cVal;
			}else{
				res = res + c;
			}
		}
		return res;
	}
	
}
