package com.basics.backtrack;

import java.util.ArrayList;
import java.util.List;

public class IPAddress {

	
	public static void main(String[] args){
		generate("25525511135");
	}
	
	public static void generate(String s){
		
		List<String> ips = new ArrayList<>();
		int[] path = new int[4];
		find(s, ips, path, 0, 0);
		System.out.println(ips);
	}
	
	public static void find(String s,List<String> ips, int[] path, int segment, int builderIndex){
		
		if(segment == 4 && builderIndex == s.length()){
			ips.add(path[0]+"."+path[1]+"."+path[2]+"."+path[3]);
			return;
		}else if(segment == 4 || builderIndex == s.length()){
			return;
		}
		
		for(int len = 1; len <=3 && builderIndex+len <= s.length(); len++){
			
			String ipPart = s.substring(builderIndex, builderIndex+len);
			int value = Integer.parseInt(ipPart);
			if(value <=0 || value > 255 || s.charAt(builderIndex) == '0'){ 
				break;
			}
			path[segment] = value;
			find(s, ips, path, segment+1, builderIndex+len);
			
			path[segment] = -1;
		}
	}
	
}
