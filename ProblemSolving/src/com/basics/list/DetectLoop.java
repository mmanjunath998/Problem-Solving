package com.basics.list;

public class DetectLoop {

	public static boolean isInLoop(Node head){
		
		boolean isTrue = false;
		
		Node slow = head, fast = head;
		while(slow != null && fast != null && fast.next != null){
			
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				isTrue = true;
				break;
			}
		}
		return isTrue;
	}
	
	public static void main(String[] args){
		Node n1 = new Node(4);
		n1.add(n1, 6);
		n1.next.next = new Node(9);
		n1.next.next.next = n1;
		
		System.out.println(isInLoop(n1));
	}
}
