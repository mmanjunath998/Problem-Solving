package com.basics.array;

import java.util.ArrayList;
import java.util.List;

public class LongestSunstringWithNoRepeatingCharLC {

	
	public static int find(String s){
		int count = 0;
		if(s == null || s.isEmpty()){
			return count;
		}
		
		char[] array = s.toCharArray();
		List<Character> list = new ArrayList<>();
		int max = 0;
		for(int i=0; i<array.length; i++){
			char c = array[i];
			if(list.contains(c)){
				
				while(true){
					char r = list.remove(0);
					max--;
					if(r == c){
						break;
					}
				}
				
			}
			list.add(c);
			max++;
			if(max > count){
				count = max;
			}
			
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(find("manjunathmadar"));
	}
	
}
