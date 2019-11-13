package com.basics.trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LexicographicallySort {
	static Trie root = new Trie();
	
	public static void main(String[] args) {
		String[] words = {
				"lexicographic", "sorting", "of", "a", "set", "of", "keys",
				"can", "be", "accomplished", "with", "a", "simple", "trie",
				"based", "algorithm", "we", "insert", "all", "keys", "in", 
				"a", "trie", "output", "all", "keys", "in", "the", "trie",
				"by", "means", "of", "preorder", "traversal", "which",
				"results", "in", "output", "that", "is", "in",
				"lexicographically", "increasing", "order",
				"preorder", "traversal", "is", "a", "kind", 
				"of", "depth", "first", "traversal"
		}; 
		
		LexicographicallySort sort = new LexicographicallySort();
		for(String word : words){
			sort.insert(word);
		}
		sort.preorder(root);
	}
	
	public  void insert(String word){
		Trie curr = root;
		for(int i=0; i<word.length(); i++){
			char c = word.charAt(i);
			if(!curr.child.containsKey(c)){
				curr.child.put(c, new Trie());
			}
			curr = curr.child.get(c);
		}
		
		curr.key = word;
		curr.count = curr.count+1;
		curr.isLast = true;
		
	}
	
	
	public void preorder(Trie curr){
		
		if(curr == null){
			return;
		}
		for(Entry<Character, Trie> entry : curr.child.entrySet()){
			
			if(entry.getValue() != null && entry.getValue().isLast){
				System.out.println(entry.getValue().key);
			}
			
			preorder(entry.getValue());
		}
	}

	static class Trie{
		String key;
		boolean isLast;
		int count;
		Map<Character, Trie> child;
		public Trie(){
			child = new HashMap<>();
		}
	}
}
