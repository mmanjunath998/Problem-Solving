package com.basics.string;

import java.util.ArrayList;
import java.util.List;

public class LargestSubstringWithoutRepeatingChar {
	
	public static void main(String[] args) {
		String str = "manjunath";
		System.out.println(find(str));
		
	}

	public static int find(String str){
		int res = 0;
		
		List<Character> list = new ArrayList<>();
		for(int i=0; i<str.length(); i++){
			char c = str.charAt(i);
			if(!list.contains(c)){
				list.add(c);
				if(list.size() > res){
					res = list.size();
				}
			}
			else{
				
				while(list.size() > 0){
					if(list.get(0) != c){
						list.remove(0);
					}else{
						break;
					}
				}
				list.remove(0);
				list.add(c);
			}
		}
		
		
		return res;
	}
}
