package com.basics.list;

public class ReveresInSize {
	
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
		Node r = rev(head, 3);
		r.print(r);
	}
	

	public static Node rev(Node head, int n){
		int k = n;
		Node prev = null;
		Node curr = head;
		Node next = null;
		while(k>0){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			k--;
		}
		if(next != null){
			head.next = rev(next, n);
		}
		
		return prev;
	}
	
}
