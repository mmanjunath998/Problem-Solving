package com.basics.string;

public class LongestCommonPrefix {

	public static void main(String[] args){
		String[] strs = {"flowers","flyow","flowight"};
		System.out.println(find(strs));
	}
	
	public static String find(String[] strs){
		String result = "";
		
		if(strs == null || strs.length == 0){
			return result;
		}
		int index = 0;
		for(char c : strs[0].toCharArray()){
			for(int i=1; i<strs.length; i++){
				if(index >= strs[i].length() || strs[i].charAt(index) != c){
					return result;
				}
			}
			result  = result+c;
			index++;
		}
		return result;
	}
}
