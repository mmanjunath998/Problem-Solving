package com.basics.list;

public class SortTwoSortedList {

	
	public static Node sort(Node a, Node b){
		return merge(a, b);
	}
	
	public static Node merge(Node a, Node b){
		if(a == null){
			return b;
		}
		
		if( b== null){
			return a;
		}
		
		Node result = null;
		if(a.data < b.data){
			result = a;
			result.next = merge(a.next, b);
		}else{
			result = b;
			result.next = merge(a, b.next);
		}
		return result;
	}
	
	public static void main(String[] args){
		Node head1 = new Node(2);
		head1.add(head1, 4);
		head1.add(head1, 6);
		
		
		Node head2 = new Node(3);
		head2.add(head2, 5);
		head2.add(head2, 7);
		
		
		Node res = merge(head1, head2);
		res.print(res);
		
	}
}
