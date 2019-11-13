package com.basics.stack;

class Stack{
	
	private int min;
	private int[] sk;
	int capacity;
	
	Stack(int size){
		sk = new int[size];
	}
	
	public boolean isFull(){
		return capacity == sk.length;
	}
	
	public boolean isEmpty(){
		return capacity == 0;
	}
	
	public void push(int value){
		if(isFull()){
			System.out.println("stack is full....");
			return;
		}
		
		if(isEmpty()){
			sk[capacity++] = value;
			min = value;
		}else if(value >= min){
			sk[capacity++] = min*value;
		}else{
			int v = min*value+1;
			sk[capacity++] = v;
			min = value;
		}
	}
	
	public int pop(){
		if(isEmpty()){
			System.out.println("stack is empty...");
			throw new IllegalAccessError();
		}
		
		int value = sk[capacity--];
		if(value % min == 0){
			return value/min;
		}else{
			int res = min;
			min = value/min;
			return res;
		}
	}
	
	public int getMin(){
		return min;
	}
	
}
public class MinInStack {

	public static void main(String[] args) {
		Stack sk = new Stack(7);
		sk.push(5);
		System.out.println(sk.getMin());
		sk.push(8);
		System.out.println(sk.getMin());
		sk.push(4);
		System.out.println(sk.getMin());
		sk.push(7);
		System.out.println(sk.getMin());
		sk.push(3);
		System.out.println(sk.getMin());
		sk.push(6);
		System.out.println(sk.getMin());
		System.out.println("poping.........");
		System.out.println(sk.pop());
		System.out.println(sk.getMin());
		System.out.println("poping.........");
		System.out.println(sk.pop());
		System.out.println(sk.getMin());
		System.out.println("poping.........");
		System.out.println(sk.pop());
		System.out.println(sk.getMin());
		System.out.println("poping.........");
		System.out.println(sk.pop());
		System.out.println(sk.getMin());
		System.out.println("poping.........");
		System.out.println(sk.pop());
		System.out.println(sk.getMin());
		System.out.println("poping.........");
		System.out.println(sk.pop());
		System.out.println(sk.getMin());
		System.out.println("poping.........");
		System.out.println(sk.pop());
		System.out.println(sk.getMin());
		
	}
	
}
