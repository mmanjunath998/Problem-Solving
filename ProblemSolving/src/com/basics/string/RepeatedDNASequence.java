package com.basics.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequence {

	public static void main(String[] args){
		String str = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		System.out.println(find(str, 10));
	}

	public static List<String> find(String str, int k){

		Set<String> result = new HashSet<>();
		Set<String> visited = new HashSet<>();

		for(int i=0; i<=str.length()-k; i++){

			String sub = str.substring(i, i+k);
			if(visited.contains(sub)){
				result.add(sub);	
			}else{
				visited.add(sub);
			}
		}



		return new ArrayList<>(result);
	}


	public static List<String> findDNA(String str, int k){
		Set<String> res = new HashSet<String>();
		Set<String> visited = new HashSet<String>();
		for(int i=0; i<str.length()-k; i++){

			String sub = str.substring(i, i+k);
			if(visited.contains(sub)){
				res.add(sub);
			}else{
				visited.add(sub);
			}
		}

		return new ArrayList<>(res);
	}

	public static boolean compareString(String str, int p1, int p2, int k){
		for(int i=0; i<k; i++){
			if(str.charAt(p1+i) != str.charAt(p1+i)){
				return false;
			}
		}

		return true;
	}

	/*
	 * 1: scan through the str i to n
	 * 2: for every i scan j = i+k to n
	 * 3: if we match found then compare twoStrings from 
	 * 
	 * 
	 * 
	 */
}
