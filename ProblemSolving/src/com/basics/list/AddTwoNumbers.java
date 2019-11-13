package com.basics.list;

public class AddTwoNumbers {
	
	public static void main(String[] args) {
		Node l1 = new Node(2);
		l1.add(l1, 9);
		l1.add(l1, 3);
		Node res = l1;
		Node l2 = new Node(5);
		l2.add(l2, 6);
		l2.add(l2, 6 );
		
		Node r = simple(l1, l2);
		r.print(r);
	}
	
	
	public static Node simple(Node l1, Node l2){
		
		Node p = null;
		Node dummy = new Node(0);
		p = dummy;
		int carry = 0;
		while(l1 != null || l2 != null || carry != 0){
			
			if(l1 != null){
				carry = carry + l1.data;
				l1 = l1.next;
			}
			if(l2 != null){
				carry = carry + l2.data;
				l2 = l2.next;
			}
			
			p.next = new Node(carry%10);
			carry = carry/10;
			p = p.next;
		}
		return dummy.next;
	}
	

	public static Node addTwoNumbers(Node l1, Node l2){
		Node res = l1;
		if(size(l1) < size(l2)){
			return addTwoNumbers(l2,l1);
		}
		
		l1 = reverse(l1);
		l2 = reverse(l2);
		
		int carry = 0;
		while(l1 != null && l2 != null){
			int sum = l1.data + l2.data+carry;
			l1.data = sum%10;
			carry = sum/10;
			l1 = l1.next;
			l2 = l2.next;
		}
		return res;
	}
	
	public static Node reverse(Node node){
		Node curr = node;
		Node prev = null;
		Node next = null;
		
		while(curr != null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	
	public static int size(Node node){ 
		int count = 0;
		Node curr = node;
		while(curr != null){
			count++;
			curr  = curr.next;
		}
		
		return count;
	}
}
