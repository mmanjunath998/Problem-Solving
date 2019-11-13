package com.basics.backtrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateIPAddress {
	
	public static void main(String[] args) {
		find("25525511135");
	}

	public static void find(String s){
		List<String> ips = new ArrayList<>();
		int[] path = new int[4];
		generate(ips, s, 0, 0, path);
		
		System.out.println(ips);
	}
	
	public static void generate(List<String> ipAddressList, String s, int builderIndex, int segment, int[] path){
		
		if(segment == 4 && builderIndex == s.length()){
			ipAddressList.add(path[0]+"."+path[1]+"."+path[2]+"."+path[3]);
			return;
		}else if(segment == 4 || builderIndex == s.length()){
			return;
		}
		
		for(int len=1; len<=3 && builderIndex+len <= s.length(); len++){
			String ipPart = s.substring(builderIndex, builderIndex+len);
			int value = Integer.parseInt(ipPart);
			if(value <= 0 || value > 255 || s.charAt(builderIndex) == '0'){
				break;
			}
			path[segment] = value;
			generate(ipAddressList, s, builderIndex+len, segment+1, path);
			path[segment] = -1;
		}
		
		
		
	}
}
