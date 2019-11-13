package com.basics.corejava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class SortMaps {

	public static void main(String[] args){
		
		Map<String, Integer> phoneBook = new HashMap<>();
		phoneBook.put("manjunath", 3456);
		phoneBook.put("george", 1234);
		phoneBook.put("zoy", 502);
		phoneBook.put("prasad",2001);
		System.out.println(phoneBook);

		Map<String, Integer> sortedBook = new TreeMap<>(phoneBook);
		System.out.println(sortedBook);
		
		//how to sort it by value?
		Set<Entry<String,Integer>> entrySet = phoneBook.entrySet();
		List<Entry<String, Integer>> list = new ArrayList<>(entrySet);
		
		Comparator<Entry<String, Integer>> sortMap = new Comparator<Entry<String,Integer>>(){
			
			public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2){
				if(e1.getValue() > e2.getValue()){
					return 1;
				}else{
					return -1;
				}
			}
		};
		
		Collections.sort(list, sortMap);
		System.out.println(list);
		System.out.println(phoneBook);
		Map<String, Integer> map = new LinkedHashMap<>();
		
		for(Entry<String, Integer> e : list){
			map.put(e.getKey(), e.getValue());
		}
		
		phoneBook = map;
		System.out.println(phoneBook);
	}
}
