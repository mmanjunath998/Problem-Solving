package com.basics.list;

public class SumOfTwoNumbersLC {

	
	public static Node sum(Node l1, Node l2){
		
		int l1Size = size(l1);
		int l2Size = size(l2);
		if(l2Size > l1Size){
			Node temp = l2;
			l2 = l1;
			l1 = temp;
		}
		Node res = l1;
		int carry = 0;
		
		while(l1 != null || l2 != null){
			
			if(l1 != null && l2 != null){
				int data = l1.data+l2.data+carry;
				if(data >=10){
					carry = data/10;
					data = data%10;
				}else{
					carry = 0;
				}
				l1.data = data;
				l1 = l1.next;
				l2 = l2.next;
			}else if(l1 != null && l2 == null){
				int data = l1.data + carry;
				if(data>=10){
					carry = data/10;
					data = data%10;
				}else{
					carry = 0;
				}
				l1.data = data;
				l1 = l1.next;
			}
		}
		
		if(carry>0){
			Node temp = res;
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = new Node(carry);
		}
		
		return res;
	}
	
	public static int size(Node head){
		int count = 0;
		Node temp = head;
		while(temp != null){
			count++;
			temp = temp.next;
		}
		return count;
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		//head.add(head, 4);
		//head.add(head, 3);
		//head.add(head, 6);
		Node.print(head);
		Node head2 = new Node(9);
		head2.add(head2, 9);
		//head2.add(head2, 9);
		//head2.add(head2, 7);
		Node.print(head2);
		Node res = sum(head2, head);
		Node.print(res);
	}
}
