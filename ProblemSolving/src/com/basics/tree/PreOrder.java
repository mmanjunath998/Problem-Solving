package com.basics.tree;

import java.util.Stack;

/*
 * 
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
public class PreOrder {

	public static void preOrder(Node root){
		if(root == null){
			return;
		}
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static void pre(Node root){
		Stack<Node> sk = new Stack<>();
		sk.push(root);
		
		while(!sk.isEmpty()){
			Node node = sk.pop();
			System.out.print(node.data+" ");
			
			if(node.right != null){
				sk.push(node.right);
			}
			
			if(node.left != null){
				sk.push(node.left);
			}
		}
	}
	
	public static void main(String[] args){
		Node tree = Node.getTree();
		preOrder(tree);
		System.out.println(" ");
		pre(tree);
	}
}
