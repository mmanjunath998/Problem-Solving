package com.basics.array;

import java.util.HashMap;
import java.util.Map;

public class RomanToNumber {
	
	public static void main(String[] args){
		String s = "LVIII";
		System.out.println(find(s));
	}
	
	public static int find(String s){
		Map<String, Integer> map = getRomanMapping();
		int value = 0;
		String prev = "A";
		for(int i=s.length()-1; i>=0; i--){
			String c = String.valueOf(s.charAt(i));
			if(map.get(c) < map.get(prev)){
				value = value - map.get(String.valueOf(c));
			}else{
				value = value + map.get(String.valueOf(c));
			}
			prev = c;
		}
		
		return value;
	}

	public static Map<String, Integer> getRomanMapping(){
		
		
		Map<String, Integer> map  = new HashMap<String, Integer>();
		
		map.put("A", 0);
		map.put("I", 1);
		map.put("V", 5);
		map.put("X", 10);
		map.put("L", 50);
		map.put("C", 100);
		map.put("D", 500);
		map.put("M", 1000);
		/*
		map.put("IV", 4);
		map.put("IX", 9);
		map.put("XL", 40);
		map.put("XC", 90);
		map.put("CD", 400);
		map.put("CM", 900);*/
		
		return map;
	}
}
