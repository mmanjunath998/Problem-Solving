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

/*
 * 1: Get the Set<Entry> from map.entrySet();
 * 2: Create List<Entry> from set ie list
 * 3: write Comparator<Entry> comp 
 * 4: Collections.sort(list, comp)
 * 5: Define new LinkedHashMap (LinkedHashMap keeps the insertion order)
 */
public class SortMapByValue {

	
	public static void main(String[] args){
		
		sort();
	}
	
	public static void sort(){
		Map<String, Integer> phoneBook = new HashMap<String, Integer>();
		phoneBook.put("appleInc", 3456);
		phoneBook.put("microsoft", 1234);
		phoneBook.put("dellIncorpration", 502);
		phoneBook.put("hpTechnology",2001);
		System.out.println("original ");
		System.out.print(phoneBook);
		//sort by keys	
		Map<String, Integer> sortedBook = new TreeMap<>(phoneBook);
		System.out.println(" ");
		System.out.println("by key........................");
		System.out.print(sortedBook);
		
		
		//sort by value
		Set<Entry<String, Integer>> entrySet = phoneBook.entrySet();
		List<Entry<String, Integer>> list = new ArrayList<>(entrySet);
		
		Comparator<Entry<String, Integer>> byValue = new Comparator<Entry<String, Integer>>(){
			
			public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2){
				if(e1.getValue() > e2.getValue()){
					return 1;
				}else{
					return -1;
				}
			}
		};
		Collections.sort(list, byValue);
		
		Map<String, Integer> sortedByValue = new LinkedHashMap<>();
		for(Entry<String, Integer> entry : list){
			sortedByValue.put(entry.getKey(), entry.getValue());
		}
		System.out.println(" ");
		System.out.println("by value............................");
		System.out.println(sortedByValue);
	}
	
	
	
	
	
}
