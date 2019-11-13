package com.basics.lt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class WordBreakII140 {
	
	public static void main(String[] args){
		List<String> dict = Arrays.asList("cat", "cats", "and", "sand", "dog");
		System.out.println(wordBreak("catsanddog", dict));
	}

	public static List<String> wordBreak(String s, List<String> dict){
		List<String> result = new ArrayList<>();
		if(s == null || s.length() == 0 || !canForm(s, dict)){
			return result;
		}
		Arrays.sort(null, new Comparator<String>(){
			
			public int compare(String s1, String s2){
				return s.length()-s2.length();
			}
		});
		helper(s, dict, 0, "", result);

		return result;
	}
	
	private static void helper(String s, List<String> dict, int start, String sol, List<String> result){
		
		if(start == s.length()){
			result.add(sol);
			return;
		}
		for(int i=start; i<s.length(); i++){
			String sub = s.substring(start, i+1);
			if(dict.contains(sub)){
				String path = sol+(sol.length() == 0 ? "":" ")+sub;
				helper(s, dict, i+1, path, result);
			}
		}
		
	}

	private static boolean canForm(String s, List<String> dict){

		boolean[] dp = new boolean[s.length()];

		for(int i=0; i<s.length(); i++){
			for(int j=0; j<=i; j++){
				String sub = s.substring(j, i+1);
				if(j == 0 || dp[j-1]){

					if(dict.contains(sub)){
						dp[i] = true;	
					}

				}
			}
		}

		return dp[s.length()-1];
	}

}
