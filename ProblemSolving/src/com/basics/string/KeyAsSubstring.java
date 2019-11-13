package com.basics.string;

import java.util.ArrayList;
import java.util.List;

public class KeyAsSubstring {
	
	public static void main(String[] args){
		String[] src = {"minecraftgame", "intelligentcr", "innercrafttalent", "knife","carf", "scissor", "stonecrafter"};
		String key = "craft";
		System.out.println(findAll(src, key));
	}

	public static List<String> findAll(String[] src, String key){
		List<String> result  = new ArrayList<>();
		
		for(String str : src){
			
			if(str.length() >= key.length() && compareString(str, key)){
				result.add(str);
			}
		}
		
		return result;
	}
	
	public static boolean compare(String str, String key){
		int k = key.length();
		for(int i=0; i<=str.length()-k; i++){
			String sub = str.substring(i, i+k);
			if(key.equals(sub)){
				return true;
			}
		}
		
		return false;
	}

	private static boolean compareString(String str, String key) {
		
		for(int i=0; i<str.length(); i++){
			if(str.charAt(i) == key.charAt(0)){
				int count = 0, p = 0;
				for(int j=i; j<str.length() && p<key.length(); j++){
					if(str.charAt(j) != key.charAt(p)){
						break;
					}
					p++;
					count++;
				}
				if(count == key.length()){
					return true;
				}
			}
		}
		
		return false;
	}
}
