package com.basics.list;

import java.util.HashSet;
import java.util.Set;

public class FindMergePoint {
	
	public static void main(String[] args){
		Node n1 = new Node(1);
		Node n2 = new Node(3);
		Node n3 = new Node(5);
		Node n4 = new Node(7);
		Node n5 = new Node(9);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		Node a1 = new Node(2);
		Node a2 = new Node(4);
		a1.next = a2;
		a2.next = n4;
		
		Node res = find(n1, a1);
		System.out.println(res.data);
		System.out.println(findByHash(n1, a1).data);
		
		
	}
	
	public static Node findByHash(Node n1, Node n2){
		Set<Node> set = new HashSet<Node>();
		while(n1 != null){
			set.add(n1);
			n1 = n1.next;
		}
		
		while(n2 != null){
			if(set.contains(n2)){
				return n2;
			}
			n2 = n2.next;
		}
		
		return null;
	}

	public static Node find(Node n1, Node n2){
		int count1 = count(n1);
		int count2 = count(n2);
		int diff = Math.abs(count1-count2);
		if(count1 > count2){
			return intersection(n1, n2, diff);
		}else{
			return intersection(n2, n1, diff);
		}
	}
	
	public static Node intersection(Node n1, Node n2, int k){
		//move the large node to k time forward
		while( k > 0){
			n1 = n1.next;
			k--;
		}
		
		//now both n1 and n2 are having same number of nodes
		while(n1 != null && n2 != null){
			if(n1 == n2){
				return n1;
			}
			n1 = n1.next;
			n2 = n2.next;
		}
		return null;
	}
	
	
	public static int count(Node head){
		int count = 0;
		Node temp = head;
		while(temp != null){
			count++;
			temp = temp.next;
		}
		return count;
	}
}
