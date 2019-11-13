package com.basics.design;

import java.util.HashMap;
import java.util.Map;

/*
 * class Node {
 * int key;
 * int value;
 * Node next;
 * Node prev;
 * 
 * }
 */
public class LRUCacheTest {

	private int capacity;
	private Node head;
	private Node end;
	Map<Integer, Node> map;
	
	public LRUCacheTest(int capacity){
		this.capacity = capacity;
		map = new HashMap<Integer, Node>();
	}
	
	public static void main(String[] args){
		LRUCacheTest cache = new LRUCacheTest(3);
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
	
	public void put(int key, int value){
		if(map.containsKey(key)){
			Node old = map.get(key);
			old.value = value;
			remove(old);
			addFront(old);
		}else{
			Node newNode = new Node(key, value);
			if(map.size() == capacity){
				remove(end);
				map.remove(end.key);
				addFront(newNode);
			}else{
				addFront(newNode);
			}
			map.put(key, newNode);
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
	
	public void remove(Node node){
		if(node.prev == null){
			head = node.next;
		}else{
			node.prev.next = node.next;
		}
		
		if(node.next == null){
			end = node.prev;
		}else{
			node.next.prev = node.prev;
		}
	}
	public void addFront(Node node){
		
		if(head == null){
			head = node;
		}else{
			node.prev = null;
			node.next = head;
			head.prev = node;
			head = node;
		}
		if(end == null){
			end = head;
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
	
	
	
}
