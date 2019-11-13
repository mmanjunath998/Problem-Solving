package com.basics.list;

public class MoveNodes {
	public static void main(String[] args) {
		Node node = new Node(2);
		node.add(node, 1);
		node.add(node, 4);
		node.add(node, 6);
		node.add(node, 5);
		node.add(node, 2);
		node.add(node, 3);

		Node r = move(node, 3);
		Node.print(r);
	} 



	public static Node move(Node node , int x){

		Node l1,p1, l2, p2, curr = node;
		l1 = p1 = new Node(0);
		l2 = p2 = new Node(0);

		while(curr != null){
			if(curr.data < x){
				p1.next = curr;
				p1 =p1.next;

			}else{
				p2.next = curr;
				p2 = p2.next;
			}
			curr = curr.next;
		}

		p2.next = null;
		p1.next = l2.next;
		return l1.next;
	}
}
