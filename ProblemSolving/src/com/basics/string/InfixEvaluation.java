package com.basics.string;

import java.util.Stack;

public class InfixEvaluation {
	
	public static void main(String[] args){
		System.out.println(find("10 + 2 * 6")); 
        System.out.println(find("100 * 2 + 12")); 
        System.out.println(find("100 * ( 2 + 12 )")); 
        System.out.println(find("100 * ( 2 + 12 ) / 14")); 
		
	}

	public static int find(String exp){
		
		Stack<Integer> values = new Stack<>();
		Stack<Character> operators = new Stack<>();
		
		for(int i=0; i<exp.length(); i++){
			
			char c = exp.charAt(i);
			if(c >='0' && c <='9'){
				
				StringBuilder sb = new StringBuilder();
				while(i < exp.length() && exp.charAt(i) >='0' && exp.charAt(i) <='9'){
					sb.append(exp.charAt(i++));
				}
				int value = Integer.parseInt(sb.toString());
				values.push(value);
				i = i-1;
			}
			else if(c == '('){
				operators.push(c);
			}
			else if( c == ')'){
				while(!operators.isEmpty() && operators.peek() != '('){
					values.push(applyOn(operators.pop(), values.pop(), values.pop()));
				}
				operators.pop();
			}
			else if( c == '+' || c == '-' || c == '*' || c == '/'){
				
				while(!operators.isEmpty() && hasPrecedence(c, operators.peek())){
					values.push(applyOn(operators.pop(), values.pop(), values.pop()));
				}
				operators.push(c);
				
			}
		}
		
		while(!operators.isEmpty()){
			values.push(applyOn(operators.pop(), values.pop(), values.pop()));
		}
		
		return values.peek();
	}
	
	
	
	public static int applyOn(char op, int b, int a){
		
		switch(op){
		
		case '+' :
			return a+b;
		case '-' :
			return a-b;
		case '*' :
			return a*b;
		case '/' :	
			if( b == 0){
				System.out.println("invalid operand");
				throw new IllegalArgumentException("Invalid operand");
			}
			return a/b;
		}
		return 0;
	}
	
	public static boolean hasPrecedence(char p1, char p2){
		
		if(p2 == '(' || p2 == ')'){
			return false;
		}
		if((p1 == '*' || p1 == '/') && (p2 == '+' || p2 == '-')){
			return false;
		}
		return true;
		
	}
}
