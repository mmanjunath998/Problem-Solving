package com.basics.list;

public class SortListMergeSort {

	public static void main(String[] args){
		
		Node head = new Node(9);
		head.add(head, 3);
		head.add(head, 1);
		head.add(head, 7);
		head.add(head, 5);
		head.add(head, 8);
		head.add(head, 4);
		head.add(head, 6);
		
	
		Node merge = mergeSort(head);
		head.print(merge);
	}

	
	public static Node mergeSort(Node head){
		if(head == null || head.next == null){
			return head;
		}
		
		Node middle = getMiddle(head);
		Node nextOfMiddle = middle.next;
		middle.next = null;
		
		Node left = mergeSort(head);
		Node right = mergeSort(nextOfMiddle);
		
		Node sortedList =  merge(left, right);
		return sortedList;
	}
	
	private static Node getMiddle(Node head) {
		if(head == null){
			return head;
		}
		Node slow = head;
		Node fast = head.next;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
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
