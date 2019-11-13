package com.basics.string;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class FirstKNonRepeatingCharacters {

	public static void main(String[] args){
		
		String input = "geeksforgeeks";
		findNaive(input, 3);
		
	}
	
	static class Pair{
		int index;
		int count;
		public Pair(int index, int count){
			this.index = index;
			this.count = count;
		}
	}
	
	public static void find(String s, int k){
		Map<Character, Pair> map = new HashMap<>();
		
		for(int i=0; i<s.length(); i++){
			if(!map.containsKey(s.charAt(i))){
				map.put(s.charAt(i), new Pair(i, 1));
			}else{
				Pair pair = map.get(s.charAt(i));
				pair.index = i;
				pair.count = pair.count+1;
			}
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(Entry<Character, Pair> entry : map.entrySet()){
			
			int count = entry.getValue().count;
			int index = entry.getValue().index;
			
			if(count == 1){
				
			}
		}
	}
	
	public static void findNaive(String input, int k){
		
		int[] charCount = getCharCount(input);
		
		int count = 0;
		for(int i= 0; i<input.length(); i++){
			if(charCount[input.charAt(i)-'a'] == 1 && count<k){
				System.out.print(input.charAt(i)+" ");
				count++;
			}
			
			if(count >= k){
				return;
			}
			
		}
	}

	private static int[] getCharCount(String input) {
		int[] charCount = new int[26];
		for(int i=0; i<input.length(); i++){
			charCount[input.charAt(i)-'a']++;
		}
		
		return charCount;
	}
}
