package com.basics.leetcode;

import java.util.Stack;

public class LengthOfValidParentheses32 {
	
	public static void main(String[] args){
		String s = ")()()())";
		System.out.println(find(s));
	}
	
	//Runtime: 2 ms, faster than 72.03% of Java online submissions 
	public static int find(String s){
		
		int left = 0, right = 0, maxLength = 0;
		
		for(int i=0; i<s.length(); i++){
			
			if(s.charAt(i) == '('){
				left++;
			}else{
				right++;
			}
			
			if(left == right){
				maxLength = Math.max(maxLength, left+right);
			}else if(right > left){
				left = right = 0;
			}
		}
		
		left = right = 0;
		for(int i=s.length()-1; i>=0; i--){
			
			if(s.charAt(i) == '('){
				left++;
			}else{
				right++;
			}
			
			if(left == right){
				maxLength = Math.max(maxLength, left+right);
			}else if(left > right){
				right = left = 0;
			}
		}
		
		
		return maxLength;
	}
	

	public static int find2(String s){
		if(s == null || s.length() == 0){
			return 0;
		}
		
		int result = 0;
		Stack<Integer> sk = new Stack<>();
		sk.push(-1);
		for(int i=0; i<s.length(); i++){
			
			char c = s.charAt(i);
			if(c == '('){
				sk.push(i);
			}else{
				
				sk.pop();
				
				if(!sk.isEmpty()){
					result = Math.max(result, i-sk.peek());
				}
				if(sk.isEmpty()){
					sk.push(i);
				}
			}
		}
		return result;
	}
}
