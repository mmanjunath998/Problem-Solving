package com.basics.list;

public class FindMid {


	public static Node findMid(Node head){
		Node slow = head, fast = head;

		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;

		}
		return slow;
	}

	public static Node reverseByK(Node head, int k){

		Node prev = null, next = null;
		Node curr = head;
		int n = k;
		while(n > 0 && curr != null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			n--;
		}
		if(next != null){
			head.next = reverseByK(next, k);
		}
		return prev;
	}


	public static Node reverse(Node head){
		Node prev = null, next = null;
		Node curr = head;
		while(curr != null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	public static void main(String[] args){
		Node head = new Node(1);
		head.add(head, 2);
		head.add(head, 3);
		head.add(head, 4);
		head.add(head, 5);
		head.add(head, 6);
		head.add(head, 7);
		head.add(head, 8);
		head.add(head, 9);
		head.print(head);
		Node reverseByK = reverseByK(head, 3);
		head.print(reverseByK);
		Node reverse = reverse(head);
		head.print(reverse);
		Node find = findMid(reverse);
		System.out.println(find.data);
	}
}
