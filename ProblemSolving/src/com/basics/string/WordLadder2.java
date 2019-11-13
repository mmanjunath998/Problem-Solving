package com.basics.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Node{
	String word;
	int level;
	public Node(String word, int level){
		this.word = word;
		this.level = level;
	}
}

public class WordLadder2 {

	
	public static void main(String[] args) {
		String start = "hit";
		String end = "cog";
		String[] wordList = {"hot","dot","dog","lot","log","cog"};
		System.out.println(transform(start, end, wordList));
		
	}
	public static int transform(String start, String end, String[] wordList){
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(start, 1));
		Set<String> visited = new HashSet<>();
		visited.add(start);
		while(!q.isEmpty()){
			Node node = q.poll();
			if(node.word.equals(end)){
				return node.level;
			}
			visited.add(node.word);
			List<String> words = getOneWordAway(node.word, wordList, visited);
			for(int i=0; i<words.size(); i++){
				q.add(new Node(words.get(i), node.level+1));
			}
		}
		
		return -1;
		
	}
	
	public static List<String> getOneWordAway(String start, String[] wordList, Set<String> visited){
		List<String> words = new ArrayList<>();
		for(String word : wordList){
			if(getCount(start, word) == 1 && !visited.contains(word)){
				words.add(word);
			}
		}
		return words;
	}
	
	public static int getCount(String word1, String word2){
		int count = 0;
		for(int i=0; i<word1.length(); i++){
			if(word1.charAt(i) != word2.charAt(i)){
				count++;
			}
		}
		return count;
	}
}
