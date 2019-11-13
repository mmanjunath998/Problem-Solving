package com.basics.backtrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateIPAddress2 {
	
	public static void main(String[] args) {
		generate("25525511135");
	}

	public static void generate(String ipAddress){
		
		List<String> res = new ArrayList<String>();
		search(ipAddress, 0, 4, res, "");
		System.out.println(res);
		
	}
	
	public static void search(String s, int index, int segmentsNeeded, List<String> res, String path){
		
		if(segmentsNeeded == 0){
			if(index == s.length()){ //need to consider the all the characters
				res.add(new String(path));
			}
			return;
		}
		if(index >= s.length()){
			return;
		}
		
		for(int i=1; i<=3; i++){
			String sub = index+i <s.length() ? s.substring(index, index+i): s.substring(index);
			if(isValid(sub)){
				if(segmentsNeeded == 4){
					search(s, index+i, segmentsNeeded-1, res, sub);
				}else{
					search(s, index+i, segmentsNeeded-1, res, path+"."+sub);
				}
			}
		}
		return;
		
	}

	private static boolean isValid(String sub) {
		if(sub.charAt(0) == '0'){
			return false;
		}
		int value = Integer.parseInt(sub);
		return value >= 0 && value <= 256;
	}
}
