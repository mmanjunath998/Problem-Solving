package com.basics.list;
//4-->3-->5-->1-->7--null
public class Node {

	public int data;
	public Node next;
	
	public Node(){
		
	}
	
	public Node(int data){
		this.data = data;
	}
	
	public static void print(Node head){
		Node temp = head;
		while(temp != null){
			System.out.print(temp.data+" --> ");
			temp = temp.next;
		}
		System.out.println(" ");
	}
	
	public  void add(Node head , int data){
		Node temp = head;
		Node newNode = new Node(data);
		while(temp != null && temp.next != null){
			temp = temp.next;
		}
		temp.next = newNode;
	}
	
	public static Node getNode(){
		Node node = new Node(4);
		node.add(node, 3);
		node.add(node, 5);
		node.add(node, 1);
		node.add(node, 7);
	
		
		return node;
	}
}
