package com.basics.string;

public class FindOneExtraChar {

	public static void main(String[] args){
		String s1 = "jagaa";
		String s2 = "gaja";
		find(s1, s2);
		find1(s1, s2);
	}
	
	
	public static void find1(String s1, String s2){
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		int res = 0;
		for(int i = 0; i< Math.min(c1.length, c2.length); i++){
			res = res + (c1[i]-c2[i]);
		}
		res = res + c1[c1.length-1];
		System.out.println((char)res);
	}
	
	public static void find(String s1, String s2){

		if(s1.length() < s2.length()){
			find(s2, s1);
			return;
		}

		char[] arr1 = s1.toCharArray();
		int sum = 0;

		for(int i = 0; i<arr1.length; i++){
			sum += arr1[i];
		}
		char[] arr2 = s2.toCharArray();
		for(int i=0; i<arr2.length; i++){
			sum -= arr2[i];
		}
		
		char c = (char)sum;
		System.out.println(sum);

		System.out.println(c);
	}
}
