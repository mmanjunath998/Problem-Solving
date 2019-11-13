package com.basics.list;

public class RemoveLoop {

	public static Node removeLoop(Node head){
		Node slow = head, fast = head;
		while(slow != null && fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				return remove(slow, head);
			}
		}

		return null;
	}

	public static Node remove(Node loop, Node head){

		Node ptr1 = loop.next, ptr2 = loop;
		int k = 1;
		while(ptr1 != ptr2){
			k++;
			ptr1 = ptr1.next;
		}

		ptr2 = head;
		while(k > 0){
			k--;
			ptr2 = ptr2.next;

		}

		ptr1 = head;
		while(ptr1.next != ptr2.next ){
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}

		ptr2.next = null;

		return head;
	}
	
	public static void main(String[] args){
		Node n1 = new Node(5);
		Node n2 = new Node(10);
		Node n3 = new Node(15);
		Node n4 = new Node(20);
		Node n5 = new Node(25);
		Node n6 = new Node(30);
		Node n7 = new Node(35);
		Node n8 = new Node(40);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n4;
		
		Node res = removeLoop(n1);
		res.print(res);
	}
}
