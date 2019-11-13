package com.basics.array;

import java.util.HashMap;
import java.util.Map;

class Node {
	int key;
	int val;
	Node next;
	Node prev;

	public Node(){

	}

	public Node(int key, int val){
		this.key = key;
		this.val = val;
	}
}

public class LRUCache {

	public static void main(String[] args){

		LRUCache cache = new LRUCache(4);
		cache.put(2, 200);
		cache.print();
		cache.put(1, 100);
		cache.print();
		System.out.println(cache.get(2));
		cache.print();
		cache.put(5, 500);
		cache.print();
		cache.put(4, 400);
		cache.print();
		System.out.println(cache.get(1));
		cache.print();
		cache.put(7, 700);
		cache.print();
		System.out.println(cache.get(2));
		cache.print();
		cache.put(8, 800);
		cache.print();
		System.out.println(cache.get(5));
		cache.print();
		cache.put(3, 300);
		cache.print();
		System.out.println(cache.get(1));
		cache.print();
		cache.put(6, 600);
		cache.print();
		
	}


	public void print(){
		Node temp = head;
		while(temp != null){
			System.out.print("["+temp.key+":"+temp.val+"]"+"-->");
			temp = temp.next;
		}
		System.out.println("...............");
	}



	int capacity;
	Node head = null;
	Node tail = null;

	Map<Integer, Node> map;

	public LRUCache(int capacity){
		this.capacity = capacity;
		map = new HashMap<>();
	}

	public int get(int key){
		Node node = map.get(key);
		if(node == null){
			return -1;
		}
		remove(node);
		add(node);
		return node.val;
	}

	public void put(int key, int val){

		if(map.containsKey(key)){

			Node node = map.get(key);
			remove(node);
			node.val = val;
			add(node);
		}else{

			Node newNode = new Node(key, val);
			if(map.size() == capacity){
				int tailKey = tail.key;
				remove(tail);
				map.remove(tailKey);
			}
			map.put(key, newNode);
			add(newNode);
		}
	}

	public void add(Node node){
		if(head == null){
			head = node;
			tail = head;
		}else{
			node.next = head;
			head.prev = node;
			head = node;
		}
	}

	public void remove(Node node){
		
		if(node.prev == null){
			head = node.next;
		}
		if(node.next  == null){
			tail = node.prev;
		}
		
		Node next = node.next;
		Node prev = node.prev;
		
		if(next != null){
			next.prev = prev;	
		}
		if(prev != null){
			prev.next = next;	
		}
		
	}
}
