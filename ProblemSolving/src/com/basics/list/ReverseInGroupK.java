package com.basics.list;

public class ReverseInGroupK {
	
	public static void main(String[] args){
		Node head = Node.getNode();
		Node.print(head);
		Node r = reverse(head, 3);
		Node.print(r);
	}

	public static Node reverse(Node head, int k){
		
		if(head == null || size(head) < k){
			return head;
		}
		int n = k;
		Node curr = head;
		Node prev = null;
		Node next = null;
		while(n > 0 && curr != null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			n--;
		}
		if(next != null){
			head.next = reverse(next, k);
		}
		
		return prev;
	}

	private static int size(Node head) {
		Node temp = head;
		int count = 0;
		while(temp != null){
			count++;
			temp = temp.next;
		}
		return 0;
	}
}
