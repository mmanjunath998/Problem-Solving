package com.basics.list;

public class AddOneToNumber {
	
	public static Node add(Node head){
		Node reverse = reverse(head);
		Node temp = reverse;
		Node temp2 = reverse;
		boolean isCarry = true;
		while(temp != null){
			if(isCarry){
				temp.data = temp.data +1;
			}
			
			if(temp.data == 10){
				temp.data = 0;
				isCarry = true;
			}else{
				isCarry = false;
			}
			temp2 = temp;
			temp = temp.next;
		}
		
		if(isCarry){
			temp2.next = new Node(1);
		}
		
		return reverse(reverse);
	}

	private static Node reverse(Node reverse) {
		
		Node prev = null;
		Node curr = reverse;
		Node next = null;
		while(curr != null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		return prev;
	}
	
	public static void main(String[] args){
  Node head = new Node(4);
		head.add(head, 9);
		head.add(head, 4);
		head.add(head, 9);
		head.print(head);
		Node reverse = add(head);
		reverse.print(reverse);
	}

}
