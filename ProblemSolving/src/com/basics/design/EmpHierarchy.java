package com.basics.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpHierarchy {

	public static void find(Map<String,List<String>> dataSet, String name){
		List<String> res = new ArrayList<>();
		List<String> reportees = dataSet.get(name);
		if(reportees != null){
			for(String eName : reportees){
				res.add(eName);
			}
			for(String emp : reportees){
				List<String> empList = dataSet.get(emp);
				if(empList != null){
					for(String eName : empList){
						res.add(eName);
					}
				}
			}
		}
		System.out.println("for emp : "+name+" number of "+res);
		
	}
	public static void main(String[] args){
		Map<String, List<String>> dataSet = new HashMap<String, List<String>>();
		String[] names = {"2","3","4"};
		String[] names1 = {"5","6","7"};
		String[] names2 = {"8","9","10"};
		dataSet.put("1", Arrays.asList(names));
		dataSet.put("3", Arrays.asList(names1));
		dataSet.put("5", Arrays.asList(names2));
		find(dataSet, "3");
	}
}
