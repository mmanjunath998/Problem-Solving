package com.basics.list;

public class RemoveDuplicatesInSortedList {

	
	public static Node remove(Node head){
		Node curr = head;
		
		while(curr.next != null){
			if(curr.data == curr.next.data){
				curr.next = curr.next.next;
			}else{
				curr = curr.next;
			}
		}
		return head;
	}
	
	public static void main(String[] args){
		
		Node head = new Node(1);
		head.add(head, 2);
		head.add(head, 3);
		head.add(head, 3);
		head.add(head, 3);
		head.add(head, 6);
		head.add(head, 6);
		head.add(head, 8);
		head.print(head);
		Node remove = remove(head);
		remove.print(remove);
		
	}
}
