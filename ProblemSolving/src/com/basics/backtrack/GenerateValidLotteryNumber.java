package com.basics.backtrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateValidLotteryNumber {

	public static void main(String[] args) {
		String s = "25525511135";
		generate(s);
		
	}
	public static void generate(String input){
		List<String> res = new ArrayList<String>();
		search(input, 0, 7, res, "");
		System.out.println(res);
	}
	public static void search(String s, int index, int segmentsNeeded, List<String> res, String path){
		
		if(segmentsNeeded == 0 && noDuplicates(path)){
			if(index == s.length()){
				res.add(new String(path));
			}
			return;
		}
		if(index >= s.length()){
			return;
		}
		
		for(int i=1; i<=6; i++){
			String sub = index+i < s.length() ? s.substring(index, index+i) : s.substring(index);
			if(isValid(sub)){
				
				if(segmentsNeeded == 7){
					search(s, index+i, segmentsNeeded-1, res, sub);
				}else{
					search(s, index+i, segmentsNeeded-1, res, path+" "+sub);
				}
				
			}
		}
		return;
	}
	private static boolean isValid(String sub) {
		int value = Integer.parseInt(sub);
		return value >=1 && value <=59;
	}
	
	public static boolean noDuplicates(String res){
		List<String> container = new ArrayList<>();
		String[] array = res.split(" ");
		for(String ar : array){
			if(container.contains(ar)){
				return false;
			}
			container.add(ar);
		}
		
		return true;
	}
}
