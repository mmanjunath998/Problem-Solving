package com.basics.array;

public class CountValley {

	public int find(int n , String str){
		int res =  0;
		int count = 0;
		for(char  c : str.toCharArray()){
			if(c == 'U'){
				count++;
			}else if(c == 'D'){
				count--;
			}
			
			if(count == 0){
				res++;
			}
		}
		return res;
	}
	
	public static void mian(String[] args){
		String s = "UDDDUDUU";
		CountValley c = new CountValley();
		System.out.println(c.find(s.length(), s));
			
	}
}
