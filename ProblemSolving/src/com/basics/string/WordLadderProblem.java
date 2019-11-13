package com.basics.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordLadderProblem {
	
	public static void main(String[] args) {
		String start = "hit";
		String end = "cog";
		String[] wordList = {"hot","dot","dog","lot","log","cog"};
		transform(start, end, wordList);
	}
	
	
	
	
	public static void transform(String start, String end, String[] wordList){
		Set<String> visited = new HashSet<>();
		Set<String> dictionary = getDictionary(wordList);
		dictionary.add(start);
		LinkedList<String> dfs = dfs(start, end, visited, dictionary);
		System.out.println(dfs);
		
	}
	
	public static LinkedList<String> dfs(String start, String end, Set<String> visited, Set<String> dictionary){
		
		if(start.equals(end)){
			LinkedList<String> path = new LinkedList<String>();
			path.add(start);
			return path;
		}
		
		if(visited.contains(start) || !dictionary.contains(start)){
			return null;
		}
		
		visited.add(start);
		List<String> words = getOneAway(start);
		for(String word : words){
			LinkedList<String> dfs = dfs(word, end, visited, dictionary);
			if(dfs != null){
				dfs.addFirst(start);
				return dfs;
			}
		}
		return null;
	}
	
	public static List<String> getOneAway(String word){
		List<String> words = new ArrayList<String>();
		
		for(int i=0; i<word.length(); i++){
			for(char c = 'a'; c<='z'; c++){
				String sub = word.substring(0,i) +c+ word.substring(i+1);
				words.add(sub);
			}
		}
		
		return words;
	}
	public static Set<String> getDictionary(String[] wordList){
		Set<String> dictionary = new HashSet<String>();
		for(String word : wordList){
			dictionary.add(word);
		}
		return dictionary;
	}
}
