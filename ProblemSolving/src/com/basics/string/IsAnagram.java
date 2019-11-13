package com.basics.string;

import java.util.ArrayList;
import java.util.List;

public class IsAnagram {
	
	public static void main(String[] args){
		String s1 = "abcabcbacccbcaaaacbbabc";
		String s2 = "abc";
		//System.out.println(isAnagram(s1, s2));
		find(s1, s2);
	}

	public static boolean isAnagram(String s1, String s2){
		if(s1.length()-s2.length() != 0){
			return false;
		}
		
		int[] count = new int[256];
		
		for(int i=0; i<s1.length(); i++){
			count[s1.charAt(i)]++;
		}
		
		for(int i=0; i<s2.length(); i++){
			count[s2.charAt(i)]--;
			if(count[s2.charAt(i)] < 0){
				return false;
			}
		}
		return true;
	}
	
	
	public static void find(String s1, String s2){
		
		List<Integer> result = new ArrayList<>();
		int[] count = new int[256];
		for(int i=0; i<s2.length(); i++){
			count[s2.charAt(i)]++;
		}
		
		for(int i=0; i<s1.length(); i++){
			char c = s1.charAt(i);
			if(count[c] == 1){
				if(isAnagram(s1, s2, i)){
					result.add(i);
				}
			}
		}
		System.out.println(result);
	}
	
	
	
	public static boolean isAnagram(String s1, String s2, int p){
		
		int[] count = new int[256];

		
		for(int i=p; i<p+s2.length() && i < s1.length(); i++){
			count[s1.charAt(i)]++;
		}
		
		for(int i=0; i<s2.length(); i++){
			count[s2.charAt(i)]--;
			
			if(count[s2.charAt(i)] < 0){
				return false;
			}
		}
		
		return true;
	}
}
