package com.basics.array;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.TreeMap;

public class ChacolateCut {
	
	public static void main(String[] args){
		List<Integer> asList = Arrays.asList(2 ,2 ,2 ,1 ,3 ,2 ,2 ,3 ,3 ,1 ,4 ,1 ,3 ,2 ,2 ,1 ,2 ,2 ,4 ,2 ,2 ,3 ,5 ,3 ,4 ,3 ,
				2, 1, 4 ,5 ,4);
		System.out.println(find(asList, 10, 4));
		
		Map<Integer, Integer> map = new TreeMap<>();
		Set<Entry<Integer, Integer>> set = map.entrySet();
		
		Collection<Integer> values = map.values();
		
		
	}

	public static int find(List<Integer> s, int d, int m){
		int start = 0;
		int res = 0;
		for(int i=0; i<s.size(); i++){
			int sum = 0;
			for(int j=i; j<s.size() && j<i+m; j++){
				sum = sum+s.get(j);
			}
			if(sum == d){
				res++;
			}
		}
		return res;
	}
}
