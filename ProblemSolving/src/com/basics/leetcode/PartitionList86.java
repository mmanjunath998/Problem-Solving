package com.basics.leetcode;

import com.basics.list.Node;

/*
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.
 */
public class PartitionList86 {
	
	public static void main(String[] args){
		
		Node test = Node.getNode();
		Node.print(test);
		
		test = partitionList(test, 2);
		Node.print(test);
	}
	

	public static Node partitionList(Node head, int x){
		Node l1,p1,l2,p2,p = head;
		p1 = l1 = new Node();
		p2 = l2 = new Node();
		while(p != null){
			
			if(p.data < x){
				p1.next = p;
				p1 = p1.next;
			}else{
				p2.next = p;
				p2 = p2.next;
			}
			
			p = p.next;
		}
		
		p2.next = null;
		p1.next = l2.next;
		return l1.next;
	}
	
}
