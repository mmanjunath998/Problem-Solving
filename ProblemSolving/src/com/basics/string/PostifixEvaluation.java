package com.basics.string;

import java.util.Stack;

public class PostifixEvaluation {
	
	public static void main(String[] args){
		String str = "100 200 + 2 / 5 * 7 +";
		System.out.println(find(str));
	}
	
	public static int find(String exp){
		Stack<Integer> values = new Stack<>();
		
		for(int i=0; i<exp.length(); i++){
			char c = exp.charAt(i);
			if(c == ' '){
				continue;
			}
			if(c >= '0' && c <='9'){
				StringBuilder sb = new StringBuilder();
				while(i < exp.length() && exp.charAt(i) >= '0' && exp.charAt(i) <= '9'){
					sb.append(exp.charAt(i++));
				}
				int value = Integer.parseInt(sb.toString());
				values.push(value);
				i = i-1;
			}
			else if(!values.isEmpty()){
				int res = applyOn(c, values.pop(), values.pop());
				values.push(res);
			}
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
			if(b == 0){
				System.out.print("invalid operand");
				throw new IllegalArgumentException("Invalid operand");
			}
			return a/b;
		}
		return 0;
	}
}
