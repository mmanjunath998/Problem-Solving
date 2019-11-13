package com.basics.random;

public class FindMinimumEncoding {
	
	public static void main(String[] args) {
		String str = "TESTMETET";
		System.out.println(findMin(str));
	}
	
	public static int findMin(String str){
		int res = 1;
		char first = str.charAt(0);
		for(int i=1; i<str.length(); i++){
			
			if(str.charAt(i) == first){
				
				int low = 0;
				int high = i;
				while(high < str.length() && str.charAt(low) == str.charAt(high)){
					low++;
					high++;
				}
				i = high-1;
				res++;
			}else{
				res++;
			}
		}
		return res;
	}

	public static int find(String str){
		int res = 1;
		char first = str.charAt(0);
		for(int i=1; i<str.length(); i++){
			if(str.charAt(i) == first){
				int low = 0;
				int high = i;
				while(high < str.length() && str.charAt(low) == str.charAt(high)){
					low++;
					high++;
				}
				i = high-1;
				res = res+1;
			}else{
				res++;
			}
		}
		return res;
	}
	
}
