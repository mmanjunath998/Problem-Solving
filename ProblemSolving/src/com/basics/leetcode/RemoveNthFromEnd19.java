package com.basics.leetcode;
//4-->3-->5-->1-->7--null
import com.basics.list.Node;
/*
 * Given a linked list, remove the n-th node from the end of list and return its head.
 */
public class RemoveNthFromEnd19 {
	
	public static void main(String[] args) {
		Node test = Node.getNode();
		Node.print(test);
		removeNthFromEnd(test, 2);
		Node.print(test);
	}

	public static Node removeNthFromEnd(Node head, int n){
		
		int count = 0;
		Node p1 = head, p2 = head;
		Node prev = null;
		
		while(p2 != null){
			p2 = p2.next;
			count++;
			if(count > n){
				prev = p1;
				p1 = p1.next;
			}
		}
		
		if(prev == null){
			return head.next;
		}
		prev.next = prev.next.next;
		return head;
	}
}
