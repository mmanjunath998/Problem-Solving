package com.basics.list;

public class ReverseBySizeLinkedList {

	/*
	 * 1-->2-->3-->4-->5-->6
	 * 
	 */
	
	
	
	public static Node reverseByK(Node head, int k){
		Node prev = null, next = head, curr = head;
		int n= k;
		while(n > 0 && curr != null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			n--;
		}
		if(next != null){
			head.next = reverseByK(next, k);
		}
		return prev;
	}
	
	public static Node reverse(Node head){
		Node curr = head;
		Node prev = null, next = null;
		while(curr != null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
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
		head.print(head);
		//Node find = reverse(head);
		//head.print(find);
		Node reverseByK = reverseByK(head, 3);
		reverseByK.print(reverseByK);
	}
}
