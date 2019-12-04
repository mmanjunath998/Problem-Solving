package com.basics.string;

import java.util.Stack;

public class ReversePolishNotation {

	public static void main(String[] args) {
		String[] tokens = {"2","1","+","3","*"};
		System.out.println(evaluvate(tokens));
	}

	public static int evaluvate(String[] tokens){
		Stack<Integer> sk = new Stack<>();

		for(int i=0;i<tokens.length; i++){

			switch(tokens[i]){

			case "+" :
				sk.push(sk.pop()+sk.pop());
				break;
			case "-":
				sk.push(-sk.pop()+sk.pop());
				break;
			case "*":
				sk.push(sk.pop() * sk.pop());
				break;
			case "/" :
				int right = sk.pop(), left = sk.pop();
				sk.push(left/right);
				break;
			default :
				sk.push(Integer.parseInt(tokens[i]));
			}
		}

		return sk.peek();
	}
}
