package com.basics.leetcode;

import java.util.ArrayList;
import java.util.List;


public class LongestSubstringWithoutRepeatingChar3 {
	
	public static void main(String[] args){
		System.out.println(find("abcabcbb"));
		System.out.println(find("bbbbb"));
		System.out.println(find("pwwkew"));
	}

	//Runtime: 6 ms, faster than 85.27% of Java online submissions
	public static int find(String s){
		int res = 0;

		if(s == null || s.length() == 0){
			return res;
		}

		List<Character> list = new ArrayList<>();
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			if(!list.contains(c)){
				list.add(c);
			}else{

				while(list.get(0) != c){
					list.remove(0);
				}
				list.remove(0);
				list.add(c);
				if(list.size() > res){
					System.out.println(list);
					res = list.size();
				}
			}
		}
		return res;
	}
}
