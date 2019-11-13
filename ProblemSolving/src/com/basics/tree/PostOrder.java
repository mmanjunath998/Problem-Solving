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


public class PostOrder {


	public static void postOrder(Node root){
		if(root == null){
			return;
		}

		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
	} 

	public static void post(Node root){
		Stack<Node> sk = new Stack<Node>();
		Node curr = root;

		while(curr != null || !sk.isEmpty()){

			if(curr != null){
				while(curr != null){
					sk.push(curr);
					curr = curr.left;
				}
			}else if(!sk.isEmpty() && sk.peek().right != null){
				curr = sk.peek().right;
			}else{

				Node temp = sk.pop();
				System.out.print(temp.data+" ");
				while(!sk.isEmpty() && temp == sk.peek().right){
					temp  =  sk.pop();
					System.out.print(temp.data+" ");
				}
			}
		}

	}

	public static void postByTwoStack(Node root){
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();

		s1.push(root);

		while(!s1.isEmpty()){
			Node temp = s1.pop();
			s2.push(temp);
			if(temp.left != null){
				s1.push(temp.left);	
			}
			if(temp.right != null){
				s1.push(temp.right);
			}
		}
		while(!s2.isEmpty()){
			System.out.print(s2.pop().data+" ");
		}
	}

	public static void main(String[] args){
		Node tree = Node.getTree();
		postOrder(tree);
		System.out.println(" ");
		post(tree);
		System.out.println(" ");
		postByTwoStack(tree);
	}
}
