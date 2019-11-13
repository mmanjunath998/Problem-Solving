package com.basics.array;

import java.util.Stack;

public class MinimumAllNumbers {

	public static void main(String[] args){
		int[] arr = {8,9,10,7,6,1,2,4,5,3,10,11};
		find(arr);
		System.out.println("find....................");
		find2(arr);
	}
	public static void find(int[] arr){
		
		//method 1
		int prev = -1;
		for(int i=0; i<arr.length-1; i++){
			if(arr[i]>arr[i+1]){
				for(int j=i; j>prev; j--){
					System.out.print(arr[j]+" ");
				}
				prev = i;
				System.out.println("");
			}else{
				System.out.println(".............");
			}
		}
		int i = arr.length-1;
		while(i > prev){
			System.out.print(arr[i]+" ");
			i--;
		}
	}
	
	public static void find2(int[] arr){
		Stack<Integer> sk  = new Stack<Integer>();
		for(int i=0; i<arr.length; i++){
			
			if(sk.isEmpty()){
				sk.push(arr[i]);
				System.out.println("...........");
			}else if(arr[i] > sk.peek()){
				sk.push(arr[i]);
				System.out.println("...........");
			}else{
				while(! sk.isEmpty()){
					System.out.print(sk.pop()+" ");
				}
				System.out.println("");
				sk.push(arr[i]);
			}
			
		}
		
		while(!sk.isEmpty()){
			System.out.print(sk.pop()+" ");
		}
	}
}
