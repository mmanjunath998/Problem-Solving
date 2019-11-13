package com.basics.array;

import java.util.Stack;

public class TestDolls {
	
	public static void main(String[] args) {
		int[] arr = {4,1,5,6};
		System.out.println(find(arr));
	}
	
	public static int find(int[] arr){
		int count = 0;
		
		Stack<Integer> sk = new Stack<Integer>();
		
		for(int i=0; i<arr.length;){
			if(sk.isEmpty() || sk.peek() >= arr[i]){
				sk.push(arr[i++]);
				
				if(count < sk.size()){
					count = sk.size();
					
				}
			}else{
				while(!sk.isEmpty() && sk.peek() < arr[i]){
					sk.pop();
				}
			}
		}
		return count;
	}
}
