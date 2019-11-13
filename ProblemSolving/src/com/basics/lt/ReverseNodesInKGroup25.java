package com.basics.lt;

import com.basics.list.Node;

public class ReverseNodesInKGroup25 {
	
	public static void main(String[] args){
		Node head = Node.getNode();
		Node.print(head);
		Node r = reverse(head, 4);
		Node.print(r);
	}


	public static Node reverse(Node head, int k){
		if(head == null || size(head) < k){
			return head;
		}
		Node prev = null, curr = head, next = null;
		int n = k;
		while( n > 0){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr =next;
			n--;
		}

		if(next != null){
			head.next = reverse(next, k);
		}
		return prev;
	}

	public static int size(Node head){
		int count = 0;
		Node temp = head;
		while(temp != null){
			count++;
			temp = temp.next;
		}
		return count;
	}
}
