package com.basics.design;

import java.util.HashMap;
import java.util.Map;

class Trie{
	Map<Character, Trie> child;
	boolean isLast;
	
	public Trie(){
		child = new HashMap<Character, Trie>();
		for(char i = 'a'; i<= 'z'; i++){
			child.put(i, null);
		}
	}
}

class Search{
	Trie root;
	
	public void insert(String[] names){
		root = new Trie();
		for(String name : names){
			insertUtil(name);
		}
	}
	
	public void insertUtil(String name){
		Trie itr = root;
		for(int i=0; i<name.length(); i++){
			char c = name.charAt(i);
			Trie nextNode = itr.child.get(c);
			if(nextNode == null){
				nextNode = new Trie();
				itr.child.put(c, nextNode);
			}
			itr = nextNode;
			if(name.length()-1 == i){
				itr.isLast = true;
			}
		}
	}
	
	public  void search(String query){
		String prefix = "";
		Trie itr = root;
		for(int i=0; i<query.length(); i++){
			prefix = prefix+query.charAt(i);
			Trie curr = itr.child.get(query.charAt(i));
			if(curr == null){
				System.out.println("Error no results found");
				return;
			}
			System.out.println("result for : "+prefix);
			searchUtil(prefix, curr);
			itr = curr;
		}
	}
	
	
	public void searchUtil(String prefix, Trie curr){
		if(curr.isLast){
			System.out.println(prefix);
		}
		for(char i='a'; i<='z'; i++){
			Trie node = curr.child.get(i);
			if(node != null){
				searchUtil(prefix+i, node);
			}
		}
		
	}
}

public class PrefixBasedSearch {

	public static void main(String[] args){
		String[] names = {"manju","man","apple","add","dog","addition","actor","mahesh","adopt","adjecent"};
		Search s = new Search();
		s.insert(names);
		s.search("adopt");
		
	}
}
