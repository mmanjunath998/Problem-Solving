package com.basics.lt;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22 {
	
	public static void main(String[] args) {
		System.out.println(generate(5));
	}
	
	public static List<String> generate(int n){
		List<String> result = new ArrayList<>();
		
		find(n, 0, 0, "", result);
		
		return result;
	}

	public static void find(int n, int left, int right, String path, List<String> result){
		if(left == n && right == n){
			result.add(path);
			return;
		}
		
		if(left > n){
			return;
		}
		if(right > left){
			return;
		}
		
		find(n, left+1, right, path+"(", result);
		find(n, left, right+1, path+")", result);
	}
}
