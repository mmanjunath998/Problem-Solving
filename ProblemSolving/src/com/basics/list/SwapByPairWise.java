package com.basics.list;

public class SwapByPairWise {

	public static void main(String[] args){
		Node head = Node.getNode();
		Node.print(head);
		Node r = swap(head);
		Node.print(r);
		
	}
	
	public static Node swap(Node head){
		
		Node dummyNode = new Node(0);
		dummyNode.next = head;
		Node curr = head;
		Node prev = dummyNode;
		Node next = null;
		
		while(curr != null && curr.next != null){
			
			next = curr.next;
			curr.next = next.next;
			next.next = prev.next;
			prev.next = next;
			prev = curr;
			curr = prev.next;
		}
		return dummyNode.next;
		
	}
}
