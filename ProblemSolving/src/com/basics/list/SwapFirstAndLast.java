package com.basics.list;

public class SwapFirstAndLast {

	public static void main(String[] args){

		Node n1 = new Node(1);
		n1.add(n1, 2);
		n1.add(n1, 3);
		n1.add(n1, 4);
		n1.add(n1, 5);
		n1.add(n1, 6);
		n1.add(n1, 7);
		n1.add(n1, 8);
		n1.add(n1, 9);

		n1.print(n1);

		Node res = find(n1);
		res.print(res);

	}

	public static Node find(Node head){
		Node head1 = head;
		Node head2 = getMid(head);
		Node nodeAfter = head2.next;
		head2.next = null;
		nodeAfter = reverese(nodeAfter);
		return convert(head1, nodeAfter);
	}

	public static Node convert(Node head1, Node head2){
		Node res = head1;
		Node h1Next = null, h2Next= null;
		while(head1 != null || head2 != null){
			
			if(head1 != null){
				h1Next = head1.next;
				head1.next = head2;	
			}
			if(head2 != null){
				h2Next = head2.next;
				head2.next = h1Next != null ? h1Next : h2Next;	
			}
			head1 = h1Next;
			head2 = h2Next;

		}
		return res;
	}



	public static Node reverese(Node head){
		Node curr = head;
		Node prev = null;
		while(curr != null){
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}


	public static Node getMid(Node head){
		Node slow = head;
		Node fast = head;
		Node prev = null;
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			prev = slow;
			slow = slow.next;
		}
		return prev;
	}

}
