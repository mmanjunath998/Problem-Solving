package com.basics.tree;

import java.util.LinkedList;
import java.util.Queue;

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


public class LevelOrder {

	public static void levelOrder(Node root){
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
			Node temp = q.poll();
			System.out.print(temp.data+" ");
			if(temp.left != null){
				q.add(temp.left);
			}
			if(temp.right != null){
				q.add(temp.right);
			}
		}
	}
	
	public static void printByLevel(Node root){
		Queue<Node> q = new LinkedList<Node>();
		
		q.add(root);
		q.add(null);
		
		while(! q.isEmpty()){
			Node temp  = q.poll();
			if(temp == null){
				System.out.println(" ");
				if(!q.isEmpty()){
					q.add(null);	
				}
				
			}else{
				System.out.print(temp.data+" ");
				if(temp.left != null){
					q.add(temp.left);
				}
				if(temp.right != null){
					q.add(temp.right);
				}
			}

		}
	}


	public static void main(String[] args){
		Node tree = Node.getTree();
		levelOrder(tree);
		System.out.println(" ");
		printByLevel(tree);
	}
}
