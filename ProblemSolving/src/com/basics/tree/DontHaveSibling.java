package com.basics.tree;
/*
 *            10
 *         /     \
 *        5       15
 *     /   \    /   \
 *    35   null   30     40
 *            /  \
 *           6    null
 *
 *
 */

public class DontHaveSibling {

	public static void print(Node root){
		if(root == null){
			return;
		}
		
		print(root.left);
		if((root.left == null && root.right != null) || (root.left != null && root.right == null)){
			System.out.println(root.left != null ? root.left.data : root.right.data);
		}
		print(root.right);
	}
	
	public static void main(String[] args){
		
		//Node tree = Node.getTree();
		
		Node tree = new Node(1); 
        tree.left = new Node(2); 
        tree.right = new Node(3); 
        tree.left.right = new Node(4); 
        tree.right.left = new Node(5); 
        tree.right.left.right = new Node(6); 
		print(tree);
	}
}
