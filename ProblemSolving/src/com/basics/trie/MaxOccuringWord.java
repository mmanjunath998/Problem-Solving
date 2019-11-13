package com.basics.trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MaxOccuringWord {

	static int max = -1;
	static String res = null;
	static Trie root = new Trie();	
	public static void main(String[] args){
		String[] words = {"coding","coder","makes","coding","coder","good","practice","coding",
				"i","like","coding","coder","good"};
		
		MaxOccuringWord m = new MaxOccuringWord();
		for(String word : words){
			m.insert(word);
		}
		
		m.preorder(root);
		System.out.println(res+" occured: "+max);
		
	}



	public void insert(String word){
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
			if(entry.getValue().isLast && entry.getValue().count > max){
				max = entry.getValue().count;
				res = entry.getValue().key;
			}
			preorder(entry.getValue());
		}


	}

	static class Trie{
		int count;
		String key;
		boolean isLast;
		Map<Character, Trie> child;

		public Trie(){
			child = new HashMap<>();
		}
	}

}
