package com.basics.lt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcatenatedWords {

	public static void main(String[] args){
		String[] words = {"cat", "cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdograt"};
		System.out.println(concatenatedWords(words));
	}
	
	public static List<String> concatenatedWords(String[] words){
		List<String> result = new ArrayList<>();
		Set<String> dict = new HashSet<>();
		
		Arrays.sort(words, new Comparator<String>(){
			public int compare(String s1, String s2){
				return s1.length() - s2.length();
			}
		});

		for(String word : words){
			if(canForm(word, dict)){
				result.add(word);
			}
			dict.add(word);
		}
		return result;
	}
	
	
	
	public static boolean canForm(String word, Set<String> dict){
		
		int n = word.length();
		boolean[] dp = new boolean[n];
		
		for(int i=0; i<n; i++){
			for(int j=0; j<=i; j++){
				
				if(j == 0 || dp[j-1]){
					String sub = word.substring(j, i+1);
					if(dict.contains(sub)){
						dp[i] = true;
					}
				}
			}
		}
		return dp[n-1];
	}


}
