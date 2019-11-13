package com.basics.string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FirstNonRepeatingChar {
	
	//takes O(n) time but also O(n) space
	public static void findO(String str){
		Map<Character, Integer> map = new LinkedHashMap<>();
		
		for(int i=0; i<str.length(); i++){
			char c = str.charAt(i);
			 if(map.containsKey(c)){
				 map.put(c, map.get(c)+1);
			 }else{
				 map.put(c, 1);
			 }
		}
		
		Set<Entry<Character, Integer>> entrySet = map.entrySet();
		for(Entry<Character,Integer> entry : entrySet){
			if(entry.getValue() == 1){
				System.out.println(entry.getKey());
				return;
			}
		}
		
	}

//	takes O(n2) time but also O(1) space
	public static void find(String str){
		for(int i=0; i<str.length(); i++){
			boolean isRepeated = false;
			for(int j=i+1; j<str.length(); j++){
				if(str.charAt(i) == str.charAt(j)){
					isRepeated = true;
					break;
				}
			}
			if(!isRepeated){
				System.out.println(str.charAt(i));
				break;
			}
		}
	}
	
	public static void main(String[] args){
		String s = "GeeksForGeeks";
		find(s);
		findO(s);
	}
}
