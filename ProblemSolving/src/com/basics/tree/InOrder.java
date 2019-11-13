package com.basics.tree;

import java.util.Stack;

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

public class InOrder {

	
	public static void inOrder(Node root){
		if(root == null){
			return;
		}
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
	
	
	public static void in(Node root){
		Stack<Node> sk = new Stack<Node>();
		
		Node curr = root;
		
		while(curr != null || !sk.isEmpty()){
			
			if(curr != null){
				while(curr != null){
					sk.push(curr);
					curr = curr.left;
				}
			}else if(!sk.isEmpty()){
				Node temp = sk.pop();
				System.out.print(temp.data+" ");
				if(temp.right != null){
					curr = temp.right;
				}
			}
		}
	}
	
	public static void main(String[] args){
		Node tree = Node.getTree();
		inOrder(tree);
		System.out.println(" ");
		in(tree);
	}
}
