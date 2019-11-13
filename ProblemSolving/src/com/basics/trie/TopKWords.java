package com.basics.trie;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

class Trie{
	boolean isLast;
	String key;
	int count;
	Map<Character, Trie> child;
	public Trie(){
		child = new HashMap<>();
		for(char i ='a'; i<='z'; i++){
			child.put(i, null);
		}
	}
}

public class TopKWords {

	Trie root;

	public void insert(String key){
		Trie itr = root;
		for(int i=0; i<key.length(); i++){
			char c = key.charAt(i);
			Trie curr = itr.child.get(c);
			if(curr == null){
				curr = new Trie();
				itr.child.put(c, curr);
			}
			itr = curr;
			if(i == key.length()-1){
				itr.key = key;
				itr.count = itr.count+1;
				itr.isLast = true;
			}
		}
	}


	public void preOrder(Trie curr, PriorityQueue<Node> pq){
		if(curr == null){
			return;
		}
		for(Entry<Character, Trie> entry : curr.child.entrySet()){

			Trie node = entry.getValue();
			if(node != null){
				if(node.isLast){
					pq.add(new Node(node.key, node.count));
				}
				preOrder(node, pq);
			}

		}
	}

	public void kFrequentWord(String[] words, int k){
		root = new Trie();
		PriorityQueue<Node> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(String word : words){
			insert(word);
		}
		
		preOrder(root, pq);

		while(k > 0 && !pq.isEmpty()){
			Node node = pq.poll();

			System.out.println(node.key +" : ==> : "+node.count);
			k--;
		}
	}

	public static void main(String[] args){
		String[] words = {"coding","coder","makes","coding","coder","good","practice","coding",
				"i","like","coding","coder","good"};
		TopKWords top = new TopKWords();
		top.kFrequentWord(words, 5);

	}
}

class Node implements Comparable<Node>{
	String key;
	int count;
	Node(String key, int count){
		this.key = key;
		this.count = count;
	}

	@Override
	public int compareTo(Node o){
		return this.count-o.count;
	}
}



