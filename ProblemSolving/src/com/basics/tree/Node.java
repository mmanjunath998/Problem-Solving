package com.basics.tree;
/*
 *            10
 *         /     \
 *        5       15
 *     /   \    /   \
 *    35   20   30     40
 *            /  \
 *           6    7
 *
 *
 */


public class Node {
	public int data;
	public Node left;
	public Node right;
	public Node(int data){
		this.data = data;
	}

	public Node(){

	}

	public static Node getTree(){
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(15);
		root.left.left = new Node(35);
		root.left.right = new Node(20);
		root.right.left = new Node(30);
		root.right.right = new Node(40);
		root.right.left.left = new Node(6);
		root.right.left.right = new Node(7);
		return root;
	}
	
	public static Node getBST(){
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(15);
		root.left.left = new Node(3);
		root.left.right = new Node(8);
		root.right.left = new Node(12);
		root.right.right = new Node(20);
		
		return root;
	}
	
	public static Node getTree2(){
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(15);
		root.left.left = new Node(35);
		root.left.right = new Node(20);
		root.right.left = new Node(30);
		root.right.right = new Node(40);
		root.right.left.left = new Node(6);
		return root;
	}

	public static int height(Node root){
		if(root == null){
			return 0;
		}
		int left = height(root.left);
		int right = height(root.right);

		if(left > right){
			return left + 1;
		}else{
			return right + 1;
		}
	}
	
	public static void print(Node root){
		if(root == null){
			return;
		}
		System.out.print(root.data+" ");
		print(root.left);
		print(root.right);
	}
}