package com.basics.leetcode;

import com.basics.list.Node;

public class SwapNodesInPairs24 {
	
	public static void main(String[] args){
		Node head = Node.getNode();
		Node.print(head);
		Node r = swap(head);
		Node.print(r);
	}

	public static Node swap(Node head){
		Node newHead = new Node(-1);
		newHead.next = head;
		Node curr = head, prev = newHead, next = null;
		
		while(curr != null && curr.next != null){
			next = curr.next;
			
			curr.next = next.next;
			next.next = prev.next;
			prev.next = next;
			
			prev = curr;
			curr = prev.next;
		}
		
		
		return newHead.next;
	}
}
