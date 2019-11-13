package com.basics.list;

public class SwapByPair {

	public static Node find(Node head){
		Node res = head.next;
		Node curr = head;
		Node prev = null, next = null;
		while(curr != null && curr.next != null){
			next = curr.next;
			curr.next = next.next;
			next.next = curr;
			if(prev != null){
				prev.next = next;
			}
			prev = curr;
			curr = curr.next;
		}
		return res;
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.add(head, 2);
		head.add(head, 3);
		head.add(head, 4);
		head.add(head, 5);
		head.add(head, 6);
		head.add(head, 7);
		head.add(head, 8);
		print(head);
		Node find = find(head);
		print(find);
	}

	public static void print(Node head){
		Node temp = head;
		while(temp != null){
			System.out.print(temp.data+" --> ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	
	
}

