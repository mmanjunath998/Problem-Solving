package com.basics.array;

import java.util.Stack;

public class SplitString {
	
	public static void main(String[] args) {
		System.out.println(split("LLLLRRRR"));
	}

	public static int split(String s){ Stack<Character> sk  = new Stack<>();
    
    int count = 0;
    for(int i=0; i< s.length(); i++){
        char c = s.charAt(i);
        if(sk.isEmpty() || sk.peek() == c){
                sk.push(c);
        }else{
                sk.pop();
                if(sk.isEmpty()){
                    count++;
                }
            }
    }
    return count;}
}
