package com.basics.lt;

import java.util.HashMap;
import java.util.Map;

public class LRUCache146 {

	public static void main(String[] args){
		LRUCache146 cache = new LRUCache146(4);
		System.out.println(cache.get(2));
		cache.put(2, 200);
		cache.print();
		cache.put(3, 300);
		cache.print();
		System.out.println(cache.get(2));
		cache.print();
		cache.put(4, 400);
		cache.print();
		cache.put(5, 500);
		cache.print();
		System.out.println(cache.get(2));
		cache.print();
		cache.put(6, 600);
		cache.print();
		
		cache.put(7, 600);
		cache.print();
	}
	
	public void print(){
		Node temp = head;
		while(temp != null){
			System.out.print("[key :"+temp.key+" value:"+temp.value+"]");
			temp = temp.next;
		}
		System.out.println("");
	}
	
	static class Node{
		int key;
		int value;
		Node next;
		Node prev;
		
		public Node(int key, int value){
			this.key = key;
			this.value = value;
		}
	}
	
	int capacity;
	Node head;
	Node tail;
	Map<Integer, Node> map;
	
	public LRUCache146(int capacity){
		this.capacity = capacity;
		map = new HashMap<>();
	}
	
	public int get(int key){
		
		Node node = map.get(key);
		if(node != null){
			
			remove(node);
			addFront(node);
			return node.value;
		}
		
		return -1;
	}
	
	public void put(int key, int value){
		
		if(map.containsKey(key)){
			
			Node existing = map.get(key);
			existing.value = value;
			remove(existing);
			addFront(existing);
			
		}else{
			Node newNode = new Node(key, value);
			
			if(map.size() == capacity){
				map.remove(tail.key);
				remove(tail);
			}
			map.put(key, newNode);
			addFront(newNode);
		}
	}
	
	public void remove(Node node){
		
		if(node.prev == null){
			head = node.next;
		}
		if(node.next == null){
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
	
	public void addFront(Node node){
		
		if(head == null){
			head = node;
			tail = head;
		}else{
			node.next = head;
			head.prev = node;
			head = node;
		}
	}
}
