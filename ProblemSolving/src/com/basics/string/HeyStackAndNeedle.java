package com.basics.string;

import java.util.ArrayList;
import java.util.List;

public class HeyStackAndNeedle {

	public static void main(String[] args){
		String heystack = "aaabcccccbbbbbbabcddddabc";
		String needle = "abc";
		
		List<Integer> result = find(needle, heystack);
		System.out.println(result);
	}
	public static List<Integer> find(String needle, String heystack){
		List<Integer> result = new ArrayList<Integer>();
		if(needle.length() > heystack.length() || heystack.length() == 0){
			return result;
		}
		int p = 0;
		while(p < heystack.length()){
			
			if(heystack.charAt(p) == needle.charAt(0)){
				if(compareString(heystack, needle, p)){
					result.add(p);
				}
			}
			p++;
		}
		return result;
	}
	
	public static boolean compareString(String heystack, String needle, int p){
		
		int i = 0;
		while(i<needle.length()){
			if(needle.charAt(i) != heystack.charAt(p)){
				return false;
			}
			i++;
			p++;
		}
		return true;
	}
}
