package com.basics.tree;

public class CopyOfBT {

	public static Node copy(Node root){
		if(root == null){
			return root;
		}
		
		Node temp = new Node(root.data);
		temp.left = copy(root.left);
		temp.right = copy(root.right);
		
		return temp;
		
	}
	
	public static void main(String[] args){
		Node tree = Node.getTree();
		tree.print(tree);
		System.out.println("  ....");
		Node copy = copy(tree);
		copy.print(copy);
	}
}
