package com.basics.list;

import java.util.Stack;

public class RemoveNodesSumsToZero {

	public static Node remove(Node head){
		
		Stack<Node> sk = new Stack<>();
		
		Node node = head;
		while(node != null){
			
			if(node.data < 0){
				int sum  = node.data;
				while(!sk.isEmpty()){
					Node temp = sk.pop();
					sum = sum+temp.data;
					if( sum == 0){
						node = node.next;
						break;
					}
				}
				
			}else{
				sk.push(node);
				node = node.next;
			}
		}
		Node result = new Node(0);
		while(!sk.isEmpty()){
			Node n = sk.pop();
			result.next = n;
		}
		return result.next;
	}
	
	public static void main(String[] args){
		Node n1 = new Node(4);
		n1.next = new Node(3);
		n1.next.next = new Node(-7);
		n1.next.next.next = new Node(6);
		n1.next.next.next.next = new Node(8);
		n1.next.next.next.next.next = new Node(10);
		n1.next.next.next.next.next.next = new Node(-18);
		n1.next.next.next.next.next.next.next = new Node(8);
		n1.next.next.next.next.next.next.next.next = new Node(-14);
		n1.next.next.next.next.next.next.next.next.next = new Node(20);
		n1.next.next.next.next.next.next.next.next.next.next = new Node(25);
		
		Node res = remove(n1);
		res.print(res);
		
		
	}
}
