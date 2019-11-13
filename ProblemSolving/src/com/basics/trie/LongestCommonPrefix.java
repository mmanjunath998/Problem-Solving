package com.basics.trie;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class TrieNode{
	boolean isLast;
	Map<Character, TrieNode> child;
	
	TrieNode(){
		child = new HashMap<Character, TrieNode>();
	}
}
public class LongestCommonPrefix {
	TrieNode root = new TrieNode();
	
	public void insert(String word){
		
		TrieNode itr = root;
		for(int i=0; i<word.length(); i++){
			char c = word.charAt(i);
			TrieNode curr = itr.child.get(c);
			if(curr == null){
				curr = new TrieNode();
				itr.child.put(c, curr);
			}
			itr = curr;
			if(i == word.length()-1){
				itr.isLast = true;
			}
		}
	}
	
	public String findLCP(String[] words){
		
		for(String word : words){
			insert(word);
		}
		StringBuilder sb = new StringBuilder();
		TrieNode curr = root;
		while(curr != null && !curr.isLast && curr.child.size() == 1){
			
			Iterator<Entry<Character, TrieNode>> it = curr.child.entrySet().iterator();
			if(it.hasNext()){
				Entry<Character, TrieNode> entry = it.next();
				sb.append(entry.getKey());
				curr = entry.getValue();
			}
			
		}
		return sb.toString();
	}
	
	public static void main(String[] args){
		String[] words = {"coding","coder","coding","coder","coding","coding","coder",};
		
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		
		String res = lcp.findLCP(words);
		System.out.println(res);
	}
}
