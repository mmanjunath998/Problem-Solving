package com.basics.leetcode;

import com.basics.list.Node;

public class MergeKsortedList {

	public static void main(String[] args) {
		Node[] lists = new Node[2];
		Node n1 = new Node(3);
		n1.add(n1, 4);
		n1.add(n1, 6);
		n1.add(n1, 8);
		lists[0] = n1;
		
		Node n2 = new Node(1);
		n2.add(n2, 2);
		n2.add(n2, 5);
		n2.add(n2, 20);
		lists[1] = n2;
		Node r = merge(lists,0,lists.length-1);
		Node.print(r);
	}
	
	public static Node merge(Node[] lists, int start, int end){
		
		if(start > end){
			return null;
		}
		if(start == end){
			return lists[start];
		}
		if(end-start == 1){
			return merge(lists[start], lists[end]);
		}
		
		int mid = (start + end)/2;
		Node left = merge(lists, start, mid);
		Node right = merge(lists, mid+1, end);
		return merge(left, right);
	}

	public static Node merge(Node a, Node b){

		if(a == null){
			return b;
		}
		if(b == null){
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
}
