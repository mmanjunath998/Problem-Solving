package com.basics.random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PascalTriangle {
	public static void main(String[] args) {
		pascal(5);
		System.out.println(find(5));
		
		Map<Character, Integer> map = new HashMap<>();
		
		Set<Entry<Character, Integer>> entries = map.entrySet();
		for(Entry e : entries){
			
		}
	}
	
	public static List<List<Integer>> find(int n){
		List<List<Integer>> triangles = new ArrayList<>();
		
		List<Integer> first = new ArrayList<>();
		first.add(1);
		triangles.add(first);
		
		for(int i=0; i<n; i++){
			List<Integer> triangle = new ArrayList<>();
			triangle.add(1);
			List<Integer> prev = triangles.get(i);
			for(int j=1; j<prev.size(); j++){
				triangle.add(prev.get(j-1)+prev.get(j));
			}
			triangle.add(1);
			triangles.add(triangle);
		}
		
		return triangles;
	}
	
	public static void pascal(int n){
		
		List<List<Integer>> triangles = new ArrayList<>();
		
		List<Integer> first = new ArrayList<>();
		first.add(1);
		triangles.add(first);
		for(int i=0; i<n; i++){
			List<Integer> newTriangle = new ArrayList<>();
			newTriangle.add(1);
			List<Integer> list = triangles.get(i);
			
			for(int j=1; j<list.size(); j++){
				newTriangle.add(list.get(j-1)+list.get(j));
			}
			newTriangle.add(1);
			triangles.add(newTriangle);
		}
		
		System.out.println(triangles);
	}
	
}
