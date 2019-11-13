package com.basics.string;

import java.util.Stack;

public class InfixToPostFix {
	public static void main(String[] args){
		String exp = "a+b*(c^d-e)^(f+g*h)-i";
		System.out.println(convert(exp));
	}

	public static String convert(String str){
		String res = "";
		Stack<Character> sk = new Stack<>();
		for(int i=0; i<str.length(); i++){
			char c = str.charAt(i);
			if(Character.isLetterOrDigit(c)){
				res = res + c;
			}
			else if(c == '('){
				sk.push(c);
			}
			else if(c == ')'){
				
				while(!sk.isEmpty() && sk.peek() != '('){
					res = res + sk.pop();
				}
				if(!sk.isEmpty() && sk.peek() != '('){
					System.out.println("invalid exp");
					return res;
				}
				sk.pop();
			}else{
				while(!sk.isEmpty() && precedence(c) <= precedence(sk.peek())){
					if(sk.peek() == '('){
						System.out.println("Invalid exp");
						return res;
					}
					res = res + sk.pop();
				}
				sk.push(c);
			}
		}
		
		
		return res;
	}

	private static int precedence(char c) {
		switch(c){
		
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		}
		return 0;
	}
}
