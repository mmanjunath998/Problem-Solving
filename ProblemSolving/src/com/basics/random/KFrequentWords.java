package com.basics.random;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Trie{
	boolean isLast;
	String key;
	int count;
	Map<Character, Trie> child;
	
	public Trie(){
		child = new HashMap<Character, Trie>();
		for(char i = 'a'; i<='z'; i++){
			child.put(i, null);
		}
	}
}

class QNode{
	int count;
	String key;
	public QNode (String key, int count){
		this.count = count;
		this.key = key;
	}
}


public class KFrequentWords {
	Trie root = new Trie();
	public void insert(String name){
		Trie itr = root;
		for(int i=0; i<name.length(); i++){
			char c = name.charAt(i);
			Trie curr = itr.child.get(c);
			if(curr == null){
				curr = new Trie();
				itr.child.put(c, curr);
			}
			itr = curr;
			
			if(i == name.length()-1){
				curr.key = name;
				curr.count = curr.count+1;
			}
		}
	}
	
	
	public void preorder(Trie root, PriorityQueue<QNode> pq){
		
		if(root == null){
			return;
		}
		for(Trie node : root.child.values()){
			if(node.count != 0){
				pq.add(new QNode(node.key, node.count));
			}
			preorder(node, pq);
		}
	}
	
}
