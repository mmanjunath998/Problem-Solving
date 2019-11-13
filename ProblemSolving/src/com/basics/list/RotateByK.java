package com.basics.list;

public class RotateByK {


	public static Node rotate(Node head, int k){

		while(k > 0){
			Node curr = head.next;
			Node first = head;
			first.next = null;
			Node temp = curr;
			while(curr.next != null){
				curr = curr.next;
			}
			curr.next = first;
			head = temp;
			k--;
		}
		return head;
	}
	
	public static Node rotateOptimise(Node head, int k){
		Node curr = head;
		
		// go to the kth node
		while(k > 1 && curr != null){
			k--;
			curr = curr.next;
		}
		
		// define the kthNode
		Node kthNode = curr;
		
		// go to the last node
		while(curr != null && curr.next != null){
			curr = curr.next;
		}
		
		curr.next = head;
		
		head = kthNode.next;

		kthNode.next = null;
		
		return head;
	}
	
	public static void main(String[] args){
		Node head = new Node(1);
		head.add(head, 2);
		head.add(head, 3);
		head.add(head, 4);
		head.add(head, 5);
		head.add(head, 6);
		head.add(head, 7);
		head.add(head, 8);
		head.add(head, 9);
		head.print(head);
		Node rotate = rotateOptimise(head, 5);
		head.print(rotate);
	}
}
