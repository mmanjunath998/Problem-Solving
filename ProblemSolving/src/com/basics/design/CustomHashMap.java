package com.basics.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Entry<K,V>{
	K key;
	V val;
	Entry next;
	
	public Entry(K key, V val){
		this.key = key;
		this.val = val;
	}
}

public class CustomHashMap<K,V> {
	
	
	
	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<>();
		
		List<Integer> list = new ArrayList<>();
		
		Map<Integer, Integer> synchronizedMap = Collections.synchronizedMap(map);
		List<Integer> synchronizedList = Collections.synchronizedList(list);
		
	}
	

	private Entry[] tables;
	private int capacity;
	
	public CustomHashMap(int capacity){
		this.capacity = capacity;
		tables = new Entry[capacity];
	}
	
	public void put(K key, V val){
		int hashCode = hashCode(key);
		int index = hashCode%capacity;
		
		if(tables[index] == null){
			tables[index] = new Entry(key, val);
			return;
		}
		
		Entry curr = tables[index];
		Entry prev = null;
		Entry newEntry = new Entry(key, val);
		while(curr != null){
			if(curr.key.equals(key)){
				if(prev == null){
					newEntry.next = curr.next;
					tables[index] = newEntry;
					return;
				}else{
					newEntry.next = curr.next;
					prev.next = newEntry;
					return;
				}
			}
			prev = curr;
			curr = curr.next;
		}	
		prev.next = newEntry;
		
	}
	
	
	public int hashCode(K key){
		
		return key.hashCode();
	}
	
}
