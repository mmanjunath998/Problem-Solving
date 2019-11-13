package com.basics.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;



public class EmployeeHierarchy {


	public static void find(Map<String, String> maping){

		/*
		 * 		map.put("A", "C");
				map.put("B", "C");
				map.put("C", "F");
				map.put("D", "E");
				map.put("E", "F");
				map.put("F", "F");*/
		Map<String, List<String>> hirarchy = new HashMap<String, List<String>>();
		for(Entry<String, String> entry : maping.entrySet()){
			String manager = entry.getValue();
			String emp = entry.getKey();
			if(!emp.equals(manager)){
				List<String> reportee = hirarchy.get(manager);
				if(reportee == null){
					reportee = new ArrayList<>();
				}
				reportee.add(emp);
				hirarchy.put(manager, reportee);
			}
		}


		System.out.println("results...");
		for(Entry<String,String> entry : maping.entrySet()){
			int count = 0;
			List<String> emp = hirarchy.get(entry.getKey());
			if(emp != null){
				count += emp.size();
				for(String e : emp){
					List<String> reportee = hirarchy.get(e);
					if(reportee != null){
						count = count + reportee.size();	
					}
					
				}	
			}
			
			System.out.println(entry.getKey()+": "+count);
			
		}
	}
	
	public static void main(String[] args){
		Map<String, String> map = new HashMap<String, String>();
		map.put("A", "C");
		map.put("B", "C");
		map.put("C", "F");
		map.put("D", "E");
		map.put("E", "F");
		map.put("F", "F");
		find(map);
	}
}
