package com.basics.design;

import java.util.HashMap;
import java.util.Map;


class Node
{
	int key;
	int value;
	Node next;
	Node prev;
	public Node(int key, int value){
		this.key = key;
		this.value = value;
		this.next = prev = null;
	}
}

public class LRUCache {
	private int capacity ;
	Node head;
	Node last;
	Map<Integer, Node> map;
	
	public LRUCache(int capacity){
		this.capacity = capacity;
		map = new HashMap<>();
	}
	
	private void addFront(Node node){
		if(head == null){
			head = node;
		}else{
			node.prev = null;
			node.next = head;
			head.prev = node;
			head = node;
		}
		
		if(last == null){
			last = head;
		}
		
	}
	
	private void remove(Node node){
		//is it head node
		if(node.prev == null){
			head = node.next;
		}else{
			node.prev.next = node.next;
		}
		//is it last node
		if(node.next == null){
			last = node.prev;
		}else{
			node.next.prev = node.prev;
		}
		
	}
	
	public int get(int key){
		if(map.containsKey(key)){
			Node node = map.get(key);
			remove(node);
			addFront(node);
			return node.value;
		}else{
			return -1;
		}
	}
	
	public void put(int key, int value){
		if(map.containsKey(key)){
			Node old = map.get(key);
			old.value = value;
			remove(old);
			addFront(old);
		}else{
			Node newNode = new Node(key, value);
			if(map.size() == capacity){
				remove(last);
				map.remove(last.key);
				addFront(newNode);
			}else{
				addFront(newNode);
			}
			map.put(key, newNode);
		}
	}
	public void print()
	{
		Node temp = head;
		while(temp != null){
			System.out.print(temp.key+":"+temp.value+"-->");
			temp = temp.next;
		}
		System.out.println(" ");
	}
	
	

	public static void main(String[] args){
		LRUCache cache = new LRUCache(3);
		cache.put(1, 100);
		cache.print();
		cache.put(2, 200);
		cache.print();
		cache.put(3, 300);
		cache.print();
		System.out.println(cache.get(2));
		cache.print();
		cache.put(4, 400);
		cache.print();
		cache.put(4, 410);
		cache.print();
		cache.put(5, 510);
		cache.print();
		cache.put(6, 610);
		cache.print();
	}
	
}
