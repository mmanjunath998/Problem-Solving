package com.basics.string;

import java.util.Stack;

public class PostfixExpressionEvaluvation {
	
	public static void main(String[] args){
		String exp = "100 200 + 2 / 5 * 7 +";
		System.out.println(evaluvate(exp));
	}

	public static int evaluvate(String exp){
		
		int res = 0;
		if(exp == null || exp.length() == 0){
			return res;
		}
		Stack<Integer> sk = new Stack<>();
		
		char[] expArry = exp.toCharArray();
		for(int i=0; i<expArry.length; i++){
			
			char c = expArry[i];
			if(c == ' '){
				continue;
			}else if(Character.isDigit(c)){
				int num = 0;
				while(Character.isDigit(c)){
					num = num*10 + (c-'0');
					i++;
					c = expArry[i];
				}
				sk.push(num);
				i--;
			}else{
				
				int val1 = sk.pop();
				int val2 = sk.pop();
				
				switch(c){
				
				case '+' :{
					sk.push(val2+val1);
					break;
				}
				case '-' :{
					sk.push(val2-val1);
					break;
				}
				case '*' :{
					sk.push(val2*val1);
					break;
				}
				case '/' :{
					sk.push(val2/val1);
					break;
				}
					
				}
			}
		}
		return sk.pop();
		
	}
}
