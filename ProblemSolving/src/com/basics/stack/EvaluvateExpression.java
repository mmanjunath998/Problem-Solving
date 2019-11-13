package com.basics.stack;

import java.util.Stack;

public class EvaluvateExpression {

	public static void main(String[] args) {
		System.out.println(solve("4+5*2-5"));
	}

	public static int solve(String expression){

		char[] tokens = expression.toCharArray();
		Stack<Integer> values = new Stack<Integer>();
		Stack<Character> ops = new Stack<Character>();

		for(int i=0; i<tokens.length; i++){

			if(tokens[i] == ' '){
				continue;
			}

			if(tokens[i] >= '0' && tokens[i] <='9'){
				StringBuffer sb = new StringBuffer();

				while(i>= 0 && i < tokens.length && tokens[i] >='0' && tokens[i] <= '9'){
					sb.append(tokens[i++]);
				}
				i = i-1;
				values.add(Integer.parseInt(sb.toString()));
			}
			else if(tokens[i] == '('){
				ops.add(tokens[i]);
			}
			else if(tokens[i] == ')'){
				while(!ops.isEmpty() && ops.peek() != '('){
					values.add(applyOf(ops.pop(), values.pop(), values.pop()));
				}
				ops.pop();
			}
			else if(tokens[i] =='+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/'){
				while(!ops.isEmpty() && isPrecedence(tokens[i], ops.peek())){
					values.add(applyOf(ops.pop(), values.pop(), values.pop()));
				}
				ops.add(tokens[i]);
			}
		}

		while(!ops.isEmpty()){
			values.add(applyOf(ops.pop(), values.pop(), values.pop()));
		}

		return values.peek();
	}

	public static boolean isPrecedence(char op1, char op2){
		if(op2 == '(' || op2 == ')'){
			return false;
		}
		if((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')){
			return false;
		}
		return true;

	}

	public static int applyOf(char operation, int b, int a){

		switch(operation){
		case '+':
			return a+b;
		case '-':
			return a-b;
		case '*':
			return a*b;
		case '/':
			if(b == 0){
				throw new UnsupportedOperationException("invallid input");
			}else{
				return a/b;		
			}

		}

		return -1;
	}
}